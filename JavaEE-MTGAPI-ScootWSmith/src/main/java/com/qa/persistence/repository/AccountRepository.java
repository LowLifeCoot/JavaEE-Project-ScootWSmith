package com.qa.persistence.repository;

public interface AccountRepository {
	final String SUCCESS = "This has passed";
	final String FAILURE = "Operation fail";

	String getAllAccounts();

	String createAccount(String account);

	String deleteAccount(int accountNumber);

	String updateAccount(int accountNumber, String account);
}
