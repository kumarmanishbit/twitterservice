package com.castlight.twitterservice.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.castlight.twitterservice.beans.Users;
import com.castlight.twitterservice.dbservice.AccountDao;
@Path("/user")

public class AccountService {

	// create account
	
	@POST
	@Path("/createuser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(Users user){
		System.out.println(user);
		AccountDao accountDao  = new AccountDao();
		
		return Response.status(200).entity("User "+accountDao.createUser(user).getName()+" has been created").build();
		
	}
	
	@GET
	@Path("/gettimeline/{userId}")
	@Produces({MediaType.APPLICATION_JSON}) 
	//@Consumes({MediaType.APPLICATION_JSON}) 
	public Users getTimeLine(@PathParam("userId") int user_id){
		
		AccountDao accountDataLayer = new AccountDao();	
		return accountDataLayer.getUserDetails(user_id);

	}
	
}
