package com.castlight.twitterservice.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
@NamedQuery(name="Tweet.findAll", query="SELECT t FROM Tweet t WHERE t.user_id = :user_id")
public class Tweet { 

	public String getLocation() {
		return "https://www.google.co.in/maps/place/"+getGeo_lat()+","+getGeo_long();
	}

	public void setLocation(String location) {
		this.location = location;
	}


	@Id
	private long tweet_id;
	
	@Transient
	private String location;
	
	private String tweet_text;
	
	public long getTweet_id() {
		return tweet_id;
	}

	public void setTweet_id(long tweet_id) {
		this.tweet_id = tweet_id;
	}

	public String getTweet_text() {
		return tweet_text;
	}

	public void setTweet_text(String tweet_text) {
		this.tweet_text = tweet_text;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public double getGeo_lat() {
		return geo_lat;
	}

	public void setGeo_lat(double geo_lat) {
		this.geo_lat = geo_lat;
	}

	public double getGeo_long() {
		return geo_long;
	}

	public void setGeo_long(double geo_long) {
		this.geo_long = geo_long;
	}


	private int user_id;
	
	private double geo_lat;
	
	private double geo_long;

	@Override
	public String toString() {
		return "Tweet [tweet_id=" + tweet_id + ", tweet_text=" + tweet_text + ", user_id=" + user_id + ", geo_lat="
				+ geo_lat + ", geo_long=" + geo_long + "]";
	}


}