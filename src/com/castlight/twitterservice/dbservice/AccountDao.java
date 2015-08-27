package com.castlight.twitterservice.dbservice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.castlight.twitterservice.beans.Follower;
import com.castlight.twitterservice.beans.Users;

public class AccountDao {

	static List<Users> listOfUsers = new ArrayList<>();
	public Users getUserDetails(int userId)
	{
	
	      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "twitterservice" );
	      EntityManager entitymanager = emfactory.createEntityManager();

	      Users user = entitymanager.find(Users.class, userId);
	  	
	    //  System.out.println(user.getName());
	      
		return user;
		
	}
	
	public Users createUser(Users user){
	user.setUser_id(listOfUsers.size()+1);
		listOfUsers.add(user);
		
		return user;
	}
	
	public void follow(int follower_id,int following_to){
		
		
		Follower follower = new Follower();
		follower.setFollower_id(follower_id);
		follower.setUser_id(following_to);


	      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "twitterservice" );
	      
	      EntityManager entitymanager = emfactory.createEntityManager( );
	      entitymanager.getTransaction( ).begin( );

	     
	      entitymanager.persist( follower );
	     
	      entitymanager.getTransaction( ).commit( );

	      entitymanager.close( );
	      emfactory.close( );
	}
	
}
