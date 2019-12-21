package com.yth.dto;

import java.io.Serializable;

/**
 * 
 *  loan Account
 * @author yth
 *
 */
public class LoanAccountDto implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * ID
     */
    private int id;
       
    
    /**
     * 账户名称
     */
    private String name;
    
    
    /**
     * 身份证号码
     */
    private String identityNum;
    
    /**
     * 卡号
     */
    private String cardNum;
    

    /**
     * 贷款额度
     */
    private double loanLimit;
    
    
    /**
     * 征信情况  取值 ：0-100
     * 100最好  
     */
    private int credit;
    
     /**
      * 
      */
    private String creditDesc;
    /**
     * 贷款金额
     */
    private double balance;
    
    
    /**
     * 贷款利率
     */
    private double rate;
	
    
    /**
     * 利息
     */
    private double interest;
    

    /**
     * 贷款期限（月）
     */
    private int count;
    
    /**
     * 贷款开始时间
     */
    private String beginTime;
    
    /**
     * 还款日期
     */
    private String endTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentityNum() {
		return identityNum;
	}

	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}



	public double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(double loanLimit) {
		this.loanLimit = loanLimit;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCreditDesc() {
		return creditDesc;
	}

	public void setCreditDesc(String creditDesc) {
		this.creditDesc = creditDesc;
	}
 
 
}
