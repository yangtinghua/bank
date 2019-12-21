package com.yth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yth.entity.DepositAccount;

/**
 * Deposit Account Mapper
 * 
 * @author yth
 *
 */
@Mapper
public interface DepositAccountMapper {
    @Select("select * from DepositAccount")
    public List<DepositAccount> getAllDeposit();
 
    @Select("SELECT * FROM DepositAccount where cardNum=#{cardNum} and password=#{password}")
    public List<DepositAccount> findDepositByCardNum(@Param("cardNum") String cardNum,@Param("password")String password);
    
    @Select("SELECT * FROM DepositAccount where id=#{id}")
    public List<DepositAccount> findDepositById(@Param("id")int id);

    @Insert("INSERT INTO DepositAccount(id,name,password,identityNum,cardNum,phoneNum,balance,rate,interest,createTime,beginTime,endTime,count,type) VALUES (#{id},#{name, jdbcType=VARCHAR},#{password},#{identityNum, jdbcType=VARCHAR},#{cardNum},#{phoneNum},#{balance},#{rate},#{interest},#{createTime},#{beginTime},#{endTime},#{count},#{type})")
    public int insertDepositAccount(DepositAccount depositAccount);
	
    @Delete("delete from DepositAccount where id=#{id}")
	public int delete(@Param("id")int id);
	
    @Update("update DepositAccount set balance=#{balance} where id=#{id}")
	public int update(DepositAccount depositAccount);

    @Select("SELECT * FROM DepositAccount where identityNum=#{identityNum} or cardNum=#{cardNum}")
    public List<DepositAccount> findDepositByIdentityNumOrCardNum(@Param("identityNum")String identityNum,@Param("cardNum")String cardNum);
    
    
 
}
