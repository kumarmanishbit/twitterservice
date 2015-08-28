package com.castlight.twitterservice.dbservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.castlight.twitterservice.beans.Tweet;

public class TweetDao {

	public List<?> getTweet(int userId) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("twitterservice");
		EntityManager entitymanager = emfactory.createEntityManager();

		List<?> tweetList = entitymanager.createNamedQuery("Tweet.findAll").setParameter("user_id", userId)
				.getResultList();

		for (int i = 0; i < tweetList.size(); i++) {
			System.out.println(tweetList.get(i));
		}

		return tweetList;
	}

	public Tweet createTweet(int userId, String messages, double geo_lat, double geo_long) {
		Tweet tweet = new Tweet();

		tweet.setGeo_long(geo_long);

		tweet.setUser_id(userId);

		tweet.setTweet_text(messages);

		tweet.setGeo_lat(geo_lat);

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("twitterservice");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		entitymanager.persist(tweet);

		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();

		return tweet;
	}
}
