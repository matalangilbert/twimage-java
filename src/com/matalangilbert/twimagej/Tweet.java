package com.matalangilbert.twimagej;


import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


public class Tweet {
	private Status _status=null;
		
	public String getNextStatusText() {
		updateStatus();
		return _status.getText();
	}
	
	private void updateStatus() {
		Twitter twitter = new TwitterFactory(
				).getInstance();
		Query query = new Query("happy -RT");
		try {
			QueryResult result = twitter.search(query);
			_status = result.getTweets().get(0);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
	}

}
