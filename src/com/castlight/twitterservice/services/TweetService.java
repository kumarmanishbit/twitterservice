package com.castlight.twitterservice.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.castlight.twitterservice.beans.Tweet;
import com.castlight.twitterservice.dbservice.TweetDao;

@Path("/tweet")
public class TweetService {

	@SuppressWarnings("unchecked")
	@GET
	@Path("/{user_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tweet> getTweet(@PathParam("user_id") int user_id) {

		return (List<Tweet>) new TweetDao().getTweet(user_id);
	}

	@POST
	@Path("/createtweet")
	public Response createTweet(Tweet tweet) {

		TweetDao tweetDao = new TweetDao();
		tweetDao.createTweet(tweet.getUser_id(), tweet.getTweet_text(), tweet.getGeo_lat(), tweet.getGeo_long());

		return Response.status(200).entity("Tweet Has been created Successfully!!!").build();
	}
}