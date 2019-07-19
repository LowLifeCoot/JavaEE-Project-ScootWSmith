package com.qa.service;

import javax.inject.Inject;
import javax.security.auth.login.AccountNotFoundException;

import com.qa.persistence.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository repo;

	public String getAllAccounts() {
		// TODO Auto-generated method stub
		return this.repo.getAllAccounts();
	}

	public String createAccount(String account) {
		// TODO Auto-generated method stub
		return this.repo.createAccount(account);

	}

	public String deleteAccount(int accountId) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		return this.repo.deleteAccount(accountId);
	}

	public String updateAccount(int accountId, String account) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		return this.repo.updateAccount(accountId, account);
	}

	public String getAccount(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
