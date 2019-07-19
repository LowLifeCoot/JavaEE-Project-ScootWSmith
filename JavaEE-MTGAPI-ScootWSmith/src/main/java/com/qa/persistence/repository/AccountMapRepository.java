package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository {

	private Map<Integer, Account> accountMap;

	private int count = 1;

	private JSONUtil json = new JSONUtil();

	public AccountMapRepository() {
		super();
		this.accountMap = new HashMap<Integer, Account>();
		this.json = new JSONUtil();
	}

	public String getAllAccounts() {
		// TODO Auto-generated method stub
		return this.json.getJSONForObject(this.accountMap.values());
	}

	public int numberOfMatchingAccounts(String firstName) {
		// double numberOfAcc = 0.0;

		/// Attempt 01
		// if (json.getJSONForObject(account).contains(firstName)) {
		// noAcc++;
		// }

		// Loop through map here
		/// Attempt 02
		// accountMap.forEach((key, value) -> {
		// if (value.getFirstName().equals(firstName)) {
		// System.out.println(firstName);
		// }
		// });

		// List<Account> matching = accountMap.values().stream().filter(x ->
		// firstName.equals(x.getFirstName()))
		// .collect(Collectors.toList());
		// return matching.size();
		return 0;
	}

	public String createAccount(String account) {
		Account toAdd = this.json.getObjectForJSON(account, Account.class);
		this.accountMap.put(this.count++, toAdd);
		if (this.accountMap.containsValue(toAdd)) {
			return SUCCESS;
		} else {
			return "Failed to add account";
		}
	}

	public String deleteAccount(int accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> findAccountsByFirstName(String firstName) {
		return null;
		// return this.accountMap.values().stream().filter(a ->
		// a.getFirstName().equals(firstName))
		// .collect(Collectors.toList());
	}

	public String updateAccount(int accountNumber, String account) {
		Account toUpdate = this.json.getObjectForJSON(account, Account.class);
		this.accountMap.replace(accountNumber, toUpdate);
		if (this.accountMap.containsValue(toUpdate)) {
			return FAILURE;
		} else {
			return "Failed to add account";
		}
	}

}
