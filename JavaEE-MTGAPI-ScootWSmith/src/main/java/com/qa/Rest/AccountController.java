package com.qa.Rest;

import javax.inject.Inject;
import javax.security.auth.login.AccountNotFoundException;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.qa.service.AccountService;

@Path("/account")
public class AccountController {

	@Inject
	private AccountService service;

	public void setService(AccountService service) {
		this.service = service;
	}

	@Path("/addAccount")
	@POST
	public String addAccount(String account) {
		return service.createAccount(account);
	}

	@Path("/getAllAccount")
	@GET
	public String getAllAccount() {
		return service.getAllAccounts();
	}

	@Path("/getAccount/{id}")
	@GET
	public String getAccount(@PathParam("id") Integer id) {
		return service.getAccount(id);
	}

	@POST
	@Path("/update/{id}")
	public String updateAccount(@PathParam("id") int accountId, String account) throws AccountNotFoundException {
		return this.service.updateAccount(accountId, account);
	}

	@DELETE
	@Path("/delete/{id}")
	public String deleteAccount(@PathParam("id") int accountId) throws AccountNotFoundException {
		return this.service.deleteAccount(accountId);
	}
}
