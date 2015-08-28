# twitterservice

This project is to create a new Twitter service using our SOA infrastructure, and provide these operations:
 >>>>> Create a new Twitter account
 >>>>> Add a new tweet
 >>>>> Follow someone
 >>>>> See your timeline
 
JPA : EclipseLink 
Jersey Implementation 

How To Use ? 

Task 1 >> Create a User :-

Follow following url :-

{POST}
http://localhost:8080/twitterservice/rest/tweet/createtweet

PayLoad Template:- 
{
"utc_offset": "Standard Time +0530 UTC",
"time_zone": "India Time Zone (UTC+05:30)",
"follower_counts": 0,
"following": [],
"followers": [],
"name": “Manish”
}


Task 2 >> Add a New Tweet 

Follow following url :-

{POST}
http://localhost:8080/twitterservice/rest/tweet/createtweet

PayLoad Template:- 

{
"tweet_text": "Have a nice day!!!",
"user_id": 5,
"geo_lat": 15.3548819,
"geo_long": 73.8516701
}

Task 3 >> Follow Someone 
 
{POST}
http://localhost:8080/twitterservice/rest/follow/{follower_id}/{following_to}

PayLoad Template :-
{ }

Task 4 >> See your timeline

{GET}
http://localhost:8080/twitterservice/rest/user/gettimeline/{user_id}


