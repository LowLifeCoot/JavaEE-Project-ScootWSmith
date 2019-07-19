package com.qa.persistence.repository;

import java.util.HashMap;
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
