package com.yth.util;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yth.dto.LoanAccountDto;
import com.yth.entity.DepositAccount;
import com.yth.entity.LoanAccount;

/**
 * MD5加密
 * 
 * @author yth
 *
 */
public class ServiceUtil {

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(ServiceUtil.class);

	/**
	 * 对象转换
	 * 
	 * @param password
	 * @return
	 */
	public static LoanAccount convertDeposit(DepositAccount deposit) {

		LoanAccount loan = new LoanAccount();

		loan.setName(deposit.getName());
		loan.setCardNum(deposit.getCardNum());
		loan.setIdentityNum(deposit.getIdentityNum());

		return loan;

	}

	/**
	 * 
	 * @param loan
	 * @return
	 */
	public static LoanAccountDto covertToDto(LoanAccount loan) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		LoanAccountDto dto = new LoanAccountDto();
		dto.setBalance(loan.getBalance());
		if (loan.getBeginTime() != null) {
			dto.setBeginTime(sdf.format(loan.getBeginTime()));
		}
		dto.setCardNum(loan.getCardNum());
		dto.setCount(loan.getCount());
		dto.setCredit(loan.getCredit());
		dto.setCreditDesc(loan.getCreditDesc());
		if (loan.getEndTime() != null) {
			dto.setEndTime(sdf.format(loan.getEndTime()));
		}
		dto.setId(loan.getId());
		dto.setIdentityNum(loan.getIdentityNum());
		dto.setInterest(loan.getInterest());
		dto.setLoanLimit(loan.getLoanLimit());
		dto.setName(loan.getName());
		dto.setRate(loan.getRate());

		return dto;
	}
}
