package com.qa.Rest;

import javax.inject.Inject;
import javax.security.auth.login.AccountNotFoundException;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.qa.service.DeckService;

@Path("/deck")
public class DeckController {

	@Inject
	private DeckService service;

	public void setService(DeckService service) {
		this.service = service;
	}

	@Path("/add")
	@POST
	public String addCard(String card) {
		return service.createCard(card);
	}

	@Path("/get")
	@GET
	public String getAllCard() {
		return service.getAllCard();
	}

	@Path("/get/{id}")
	@GET
	public String getCard(@PathParam("id") Integer id) {
		return service.getCard(id);
	}

	@POST
	@Path("/update/{id}")
	public String updateCard(@PathParam("id") int cardId, String card) throws AccountNotFoundException {
		return this.service.updateCard(cardId, card);
	}

	@DELETE
	@Path("/delete/{id}")
	public String deleteCard(@PathParam("id") int accountId) throws AccountNotFoundException {
		return this.service.deleteCard(accountId);
	}

}
