package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Deck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String url;
	private Integer account_ID;

	public Deck(Integer id, String name, String url, Integer account_ID) {
		super();
		this.id = id;
		this.setName(name);
		this.setUrl(url);
		this.setAccount_ID(account_ID);
	}

	public Deck() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getAccount_ID() {
		return account_ID;
	}

	public void setAccount_ID(Integer account_ID) {
		this.account_ID = account_ID;
	}
}
