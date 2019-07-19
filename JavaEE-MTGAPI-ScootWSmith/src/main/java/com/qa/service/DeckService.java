package com.qa.service;

import javax.security.auth.login.AccountNotFoundException;

public interface DeckService {
	String getAllCards();

	String createCard(String card);

	String deleteCard(int cardId) throws AccountNotFoundException;

	String updateCard(int cardId, String card) throws AccountNotFoundException;

	String getCard(Integer id);

	String getAllCard();

}
