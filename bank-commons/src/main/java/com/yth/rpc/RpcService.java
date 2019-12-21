package com.yth.rpc;

import java.util.List;

import com.yth.entity.AccountDetail;
import com.yth.entity.DepositAccount;
import com.yth.entity.LoanAccount;

public interface RpcService {

	public String test(String name);

	public List<AccountDetail> getAllAccountDetails();

	public int insertLoanAccount(AccountDetail accountDetail);

	public int deleteAccountDetail(int id);

	public List<AccountDetail> findDetailByCardNum(String cardNum);

	public List<DepositAccount> getAllDeposit();

	public List<DepositAccount> findDepositByCardNum(String cardNum, String password);

	public List<DepositAccount> findDepositById(int id);

	public int insertDepositAccount(DepositAccount depositAccount);

	public int deleteDepositAccount(int id);

	public int update(DepositAccount depositAccount);

	public List<DepositAccount> findDepositByIdentityNumOrCardNum(String identityNum, String cardNum);

	public List<LoanAccount> getAllLoans();

	public List<LoanAccount> findLoanByIdentityNumOrCardNum(String identityNum, String cardNum);

	public List<LoanAccount> findLoanById(int id);

	public int insertLoanAccount(LoanAccount loanAccount);

	public int deleteLoanAccount(int id);

	public int updateLoanAccount(LoanAccount loanAccount);
}
