package com.yth.entity;

import java.io.Serializable;

/**
 * 
 * loan Account
 * 
 * @author yth
 *
 */
public class UserCredit implements Serializable {
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
	 * 征信情况 取值 ：0-100 100最好
	 */
	private int credit;

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

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

}
