package com.castlight.twitterservice.dbservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.castlight.twitterservice.beans.Tweet;
import com.castlight.twitterservice.beans.Users;
import com.castlight.twitterservice.exception.GenericException;

public class AccountDao {

	public Users getUserDetails(int userId) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("twitterservice");
		EntityManager entitymanager = emfactory.createEntityManager();

		Users user = entitymanager.find(Users.class, userId);

		List<Integer> followerList = entitymanager.createNamedQuery("Follower.findFollowers")
				.setParameter("user_id", userId).getResultList();

		System.out.println("Followers...");
		System.out.println(followerList);

		user.setFollowers(followerList);

		user.setFollower_counts(followerList.size());

		List<Integer> followingList = entitymanager.createNamedQuery("Follower.findFollowing")
				.setParameter("user_id", userId).getResultList();

		System.out.println("Following...");
		System.out.println(followingList);

		user.setFollowing(followingList);

		List<Tweet> tweetList = entitymanager.createNamedQuery("Tweet.findAll").setParameter("user_id", userId)
				.getResultList();

		user.setTweet(tweetList);

		return user;

	}

	public Users createUser(Users user) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("twitterservice");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		entitymanager.persist(user);

		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
		return user;
	}

}
