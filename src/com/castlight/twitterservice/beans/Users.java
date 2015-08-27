package com.castlight.twitterservice.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Users {

	public List<Integer> getFollowing() {
		return following;
	}

	public void setFollowing(List<Integer> following) {
		this.following = following;
	}

	public List<Integer> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Integer> followers) {
		this.followers = followers;
	}


	private String Name;
	
	public String getUtc_offset() {
		return utc_offset;
	}

	public void setUtc_offset(String utc_offset) {
		this.utc_offset = utc_offset;
	}

	public String getTime_zone() {
		return time_zone;
	}

	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}


	@Id
	private int user_id;
	
	
	private String utc_offset;
	
	private String time_zone;
	
	private int follower_counts;
	
	@Transient
	private List<Integer> following  = new ArrayList<Integer>( );

	@Transient
	private List<Integer> followers = new ArrayList<Integer>( );
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getUser_id() {
		return user_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + follower_counts;
		result = prime * result + user_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (follower_counts != other.follower_counts)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getFollower_counts() {
		return follower_counts;
	}

	public void setFollower_counts(int follower_counts) {
		this.follower_counts = follower_counts;
	}


	@Override
	public String toString() {
		return "Users [Name=" + Name + ", user_id=" + user_id + "]";
	}

}
