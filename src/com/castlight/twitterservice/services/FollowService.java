package com.castlight.twitterservice.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.castlight.twitterservice.dbservice.AccountDao;

@Path("/follow")
public class FollowService {


	@POST
	@Path("/{follower_id}/{following_to}")
	public Response follow(@PathParam("follower_id") int follower_id , @PathParam("following_to") int following_to){
		
		new AccountDao().follow(follower_id, following_to);
		return Response.status(200).entity("User is following...").build();
	}
	
	
}
