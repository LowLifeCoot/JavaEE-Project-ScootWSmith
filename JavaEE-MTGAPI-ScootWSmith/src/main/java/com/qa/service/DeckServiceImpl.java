package com.qa.service;

import javax.inject.Inject;
import javax.security.auth.login.AccountNotFoundException;

import com.qa.persistence.repository.DeckRepositry;

public class DeckServiceImpl implements DeckService {

	@Inject
	private DeckRepositry repo;

	public String getAllCards() {
		return this.repo.getAllCards();
	}

	public String createCard(String card) {
		return this.repo.createCard(card);
	}

	public String deleteCard(int cardId) throws AccountNotFoundException {
		return this.repo.deleteCard(cardId);
	}

	public String updateCard(int cardId, String card) throws AccountNotFoundException {
		return this.repo.updateCard(cardId, card);
	}

	public String getCard(Integer id) {
		return null;
	}

	public String getAllCard() {
		return this.repo.getAllCards();
	}

}