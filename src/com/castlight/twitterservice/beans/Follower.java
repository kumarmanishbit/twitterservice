package com.castlight.twitterservice.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "followers")
@NamedQueries({
		@NamedQuery(name = "Follower.findFollowers", query = "SELECT f.follower_id FROM Follower f WHERE f.user_id = :user_id"),
		@NamedQuery(name = "Follower.findFollowing", query = "SELECT f.user_id FROM Follower f WHERE f.follower_id = :user_id") })
public class Follower {

	@Id
	private int id;
	private int user_id;
	private int follower_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getFollower_id() {
		return follower_id;
	}

	public void setFollower_id(int follower_id) {
		this.follower_id = follower_id;
	}

}
