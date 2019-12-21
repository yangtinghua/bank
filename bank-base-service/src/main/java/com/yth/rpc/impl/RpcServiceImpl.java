package com.yth.rpc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import com.yth.entity.AccountDetail;
import com.yth.entity.DepositAccount;
import com.yth.entity.LoanAccount;
import com.yth.mapper.AccountDetailMapper;
import com.yth.mapper.DepositAccountMapper;
import com.yth.mapper.LoanAccountMapper;
import com.yth.rpc.RpcService;

@MotanService(module = "test" ,group ="bank", export = "motan:1001")
public class RpcServiceImpl implements RpcService {

	@Autowired
	private AccountDetailMapper accountDetailMapper;
	
	@Autowired
	private DepositAccountMapper depositAccountMapper;
	
	@Autowired
	private LoanAccountMapper loanAccountMapper;
	
	
	
	public String test(String name) {
		System.out.println(name);
		return name+"2";
	}

	public List<AccountDetail> getAllAccountDetails() {
		// TODO Auto-generated method stub
		return accountDetailMapper.getAllAccountDetails();
	}

	public int insertLoanAccount(AccountDetail accountDetail) {
		// TODO Auto-generated method stub
		return accountDetailMapper.insertLoanAccount(accountDetail);
	}

	public int deleteAccountDetail(int id) {
		// TODO Auto-generated method stub
		return accountDetailMapper.delete(id);
	}

	public List<AccountDetail> findDetailByCardNum(String cardNum) {
		// TODO Auto-generated method stub
		return accountDetailMapper.findDetailByCardNum(cardNum);
	}

	public List<DepositAccount> getAllDeposit() {
		// TODO Auto-generated method stub
		return depositAccountMapper.getAllDeposit();
	}

	public List<DepositAccount> findDepositByCardNum(String cardNum, String password) {
		List<DepositAccount> list= null;
		try {
			 list=depositAccountMapper.findDepositByCardNum(cardNum, password);
			
		} catch (Exception e) {
			System.out.println(e);
		}
			return list;
	}

	public List<DepositAccount> findDepositById(int id) {
		// TODO Auto-generated method stub
		return depositAccountMapper.findDepositById(id);
	}

	public int insertDepositAccount(DepositAccount depositAccount) {
		// TODO Auto-generated method stub
		return depositAccountMapper.insertDepositAccount(depositAccount);
	}

	public int deleteDepositAccount(int id) {
		// TODO Auto-generated method stub
		return depositAccountMapper.delete(id);
	}

	public int update(DepositAccount depositAccount) {
		// TODO Auto-generated method stub
		return depositAccountMapper.update(depositAccount);
	}

	public List<DepositAccount> findDepositByIdentityNumOrCardNum(String identityNum, String cardNum) {
		// TODO Auto-generated method stub
		return depositAccountMapper.findDepositByIdentityNumOrCardNum(identityNum, cardNum);
	}

	public List<LoanAccount> getAllLoans() {
		// TODO Auto-generated method stub
		return loanAccountMapper.getAllLoans();
	}

	public List<LoanAccount> findLoanByIdentityNumOrCardNum(String identityNum, String cardNum) {
		// TODO Auto-generated method stub
		return loanAccountMapper.findLoanByIdentityNumOrCardNum(identityNum, cardNum);
	}

	public List<LoanAccount> findLoanById(int id) {
		// TODO Auto-generated method stub
		return loanAccountMapper.findLoanById(id);
	}

	public int insertLoanAccount(LoanAccount loanAccount) {
		// TODO Auto-generated method stub
		return loanAccountMapper.insertLoanAccount(loanAccount);
	}

	public int deleteLoanAccount(int id) {
		// TODO Auto-generated method stub
		return loanAccountMapper.delete(id);
	}

	public int updateLoanAccount(LoanAccount loanAccount) {
		// TODO Auto-generated method stub
		return loanAccountMapper.update(loanAccount);
	}

}
