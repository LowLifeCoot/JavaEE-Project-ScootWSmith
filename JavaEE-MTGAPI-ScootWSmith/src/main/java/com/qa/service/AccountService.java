package com.qa.service;

public interface AccountService {
	String getAllAccounts();

	String createAccount(String account);

	String deleteAccount(int accountId);

	String updateAccount(int accountId, String account);

	String getAccount(Integer id);

	String login(String account);

	boolean checkUsername(String account);
}
