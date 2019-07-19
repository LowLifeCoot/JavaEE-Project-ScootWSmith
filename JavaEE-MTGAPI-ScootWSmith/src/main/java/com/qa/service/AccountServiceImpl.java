package com.qa.service;

import javax.inject.Inject;
import javax.security.auth.login.AccountNotFoundException;

import com.qa.persistence.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository repo;

	public String getAllAccounts() {
		return this.repo.getAllAccounts();
	}

	public String createAccount(String account) {
		return this.repo.createAccount(account);

	}

	public String deleteAccount(int accountId) throws AccountNotFoundException {
		return this.repo.deleteAccount(accountId);
	}

	public String updateAccount(int accountId, String account) throws AccountNotFoundException {
		return this.repo.updateAccount(accountId, account);
	}

	public String getAccount(Integer id) {
		return null;
	}

}
