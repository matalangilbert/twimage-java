package com.matalangilbert.twimagej;


import java.util.List;

import twitter4j.*;


public class UpdateStatus {
	public static Status getNew() {
		Twitter twitter = new TwitterFactory(
				).getInstance();
		Query query = new Query("happy -RT");
		try {
			QueryResult result = twitter.search(query);
			return (result.getTweets().get(0));
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return null;
	}
}
