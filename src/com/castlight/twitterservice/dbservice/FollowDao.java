package com.castlight.twitterservice.dbservice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.castlight.twitterservice.beans.Follower;

public class FollowDao {

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
