package com.qa.persistence.repository;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Default
@Transactional(value = TxType.SUPPORTS)
public class AccountDBRepositry implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil json;

	public String getAllAccounts() {
		// TODO Auto-generated method stub
		TypedQuery<Account> query = em.createQuery("SELECT a FROM ACCOUNT a", Account.class);
		return query.getResultList().toString();
	}

	@Transactional(value = TxType.REQUIRED)
	public String createAccount(String account) {
		Account toCreate = this.json.getObjectForJSON(account, Account.class);
		this.em.persist(toCreate);
		return account;
	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(int accountNumber) {
		// TODO Auto-generated method stub
		Account accountTemp = em.find(Account.class, accountNumber);
		em.remove(accountTemp);
		return "Removed account: " + accountTemp;
	}

	@Transactional(value = TxType.REQUIRED)
	public String updateAccount(int accountNumber, String account) {
		// TODO Auto-generated method stub
		// if id is same then replace data at database

		// attempt 01
		// TypedQuery<Account> query = em.createQuery("UPDATE ACCOUNT SET Account = :acc
		// + WHERE Id = :id", Account.class);
		//
		// query.setParameter("acc", accountNumberc);
		// query.setParameter("id", );
		//
		// attempt 02
		// TypedQuery<Account> query = em.createQuery("UPDATE a FROM ACCOUNT a WHERE Id
		// = " + id, Account.class);
		return null;
	}

	public int numberOfMatchingAccounts(String firstName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Account findAccount(Long id) {
		return em.find(Account.class, id);
	}

	public List<Account> findAccountsByFirstName(String firstName) {
		TypedQuery<Account> query = this.em.createQuery("SELECT a FROM Account a WHERE a.firstName = :firstName",
				Account.class);
		query.setParameter("firstName", firstName);
		return query.getResultList();
	}
}
