package com.yth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.yth.entity.UserCredit;

/**
 * usercredit Mapper
 * 
 * @author yth
 *
 */
@Mapper
public interface UserCreditMapper {

 
    @Select("SELECT * FROM UserCredit where identityNum=#{identityNum}  order by id desc")
    public List<UserCredit> findLoanByIdentityNum(String identityNum);
    
   
    
    

 
}
