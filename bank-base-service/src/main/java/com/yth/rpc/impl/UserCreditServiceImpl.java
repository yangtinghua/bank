package com.yth.rpc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import com.yth.entity.UserCredit;
import com.yth.mapper.UserCreditMapper;
import com.yth.rpc.UserCreditService;

@MotanService(module = "credit", group = "bank", export = "motan:1002")
public class UserCreditServiceImpl implements UserCreditService {

	@Autowired
	private UserCreditMapper userCreditMapper;

	public UserCredit queryUserCredit(String identityNum) {

		List<UserCredit> list = userCreditMapper.findLoanByIdentityNum(identityNum);
		if (list == null || list.isEmpty()) {

			return null;
		}
		return list.get(0);
	}

}
