package com.yth.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import com.yth.bean.TradeType;
import com.yth.entity.DepositAccount;
import com.yth.entity.LoanAccount;
import com.yth.entity.UserCredit;
import com.yth.rpc.RpcService;
import com.yth.rpc.UserCreditService;
import com.yth.service.DepositAccountService;
import com.yth.service.LoanAccountService;
import com.yth.util.ServiceUtil;

/**
 * 存款账户服务类
 * 
 * @author yth
 *
 */
@Service
public class LoanAccountServiceImpl implements LoanAccountService {

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(LoanAccountServiceImpl.class);

	@MotanReferer(module = "test", group = "bank")
	private RpcService service;

	@MotanReferer(module = "credit", group = "bank")
	private UserCreditService creditService;

	@Autowired
	private DepositAccountService depositAccountService;

	//
	@Override
	public List<LoanAccount> findLoanByIdentityNumOrCardNum(LoanAccount loan) {

		List<LoanAccount> list = this.findLoanByIdentityNumOrCardNum(loan.getIdentityNum(), loan.getCardNum());
		return list;
	}

	@Override
	public LoanAccount queryCredit(String identityNum) {

		List<LoanAccount> list = this.findLoanByIdentityNumOrCardNum(identityNum, "");

		LoanAccount loan = list.get(0);

		UserCredit userCredit = creditService.queryUserCredit(identityNum);
		if (userCredit == null) {
			loan.setCreditDesc("bad");
		} else {
			if (userCredit.getCredit() > 70) {
				loan.setCreditDesc("good");
			} else if (userCredit.getCredit() < 50) {
				loan.setCreditDesc("bad");
			}
		}

		return loan;

	}

	/**
	 * findLoanByIdentityNumOrCardNum
	 * 
	 * @param identityNum
	 * @param cardNum
	 * @return
	 */
	public List<LoanAccount> findLoanByIdentityNumOrCardNum(String identityNum, String cardNum) {

		List<LoanAccount> list = service.findLoanByIdentityNumOrCardNum(identityNum, cardNum);

		if (list == null || list.isEmpty()) {
			list = new ArrayList<LoanAccount>(1);

			List<DepositAccount> deposits = service.findDepositByIdentityNumOrCardNum(identityNum, cardNum);

			if (deposits == null || deposits.isEmpty()) {

				logger.info("please open diposit account first ! ");

				return null;

			}
			DepositAccount deposit = deposits.get(0);

			LoanAccount loan = ServiceUtil.convertDeposit(deposit);
			loan.setId(deposit.getId());
			loan.setLoanLimit(100000);
			loan.setCredit(80);
			loan.setRate(0.005);
			service.insertLoanAccount(loan);
			list.add(loan);
		}

		return list;
	}

	@Override
	public List<LoanAccount> loan(LoanAccount loan) throws Exception {

		// 放贷
		this.doLoan(loan);

		// 贷款金额存入用户账户
		this.depositToAccount(loan.getCardNum(), loan.getBalance());

		List<LoanAccount> newlist = service.findLoanByIdentityNumOrCardNum(loan.getIdentityNum(), loan.getCardNum());

		return newlist;
	}

	/**
	 * 放贷
	 * 
	 * @param loan
	 * @throws Exception
	 */
	private void doLoan(LoanAccount loan) throws Exception {

		List<LoanAccount> list = service.findLoanByIdentityNumOrCardNum(loan.getIdentityNum(), loan.getCardNum());
		LoanAccount oldloan = list.get(0);

		oldloan.setId(oldloan.getId() + 1);
		oldloan.setBalance(loan.getBalance());
		if (oldloan.getLoanLimit() - loan.getBalance() < 0) {

			logger.info("LoanLimit  is not enough ");

			throw new Exception("LoanLimit  is not enough ");
		}

		oldloan.setLoanLimit(oldloan.getLoanLimit() - loan.getBalance());
		oldloan.setBeginTime(new Date());
		oldloan.setEndTime(new Date());
		oldloan.setCount(oldloan.getCount());
		service.insertLoanAccount(oldloan);
	}

	/**
	 * 存款存入相应账户
	 * 
	 * @param cardNum
	 * @param balance
	 */
	private synchronized void depositToAccount(String cardNum, double balance) {
		List<DepositAccount> list = service.findDepositByIdentityNumOrCardNum("", cardNum);
		DepositAccount old = list.get(0);

		double temp = old.getBalance() + balance;

		old.setBalance(temp);

		// 交易明细
		depositAccountService.toLogDetails(cardNum, balance, TradeType.Loan, temp);

		service.update(old);

	}

}
