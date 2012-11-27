package com.matalangilbert.twimagej;


import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


/**
 * Wrapper class for the Twitter API.
 * Requires a twitter4j.properties file in the root of the application directory. See README for more details.
 * @author Mat Alan Gilbert
 */
public class Tweet {
	private Status _status=null;
		
	/**
	 * Get the next tweet from the Twitter API.
	 * @return the text content of the tweet.
	 */
	public String getNextStatusText() {
		updateStatus();
		return _status.getText();
	}
	
	private void updateStatus() {
		Twitter twitter = new TwitterFactory(
				).getInstance();
		Query query = new Query("happy -RT -birthday -bday");
		try {
			QueryResult result = twitter.search(query);
			_status = result.getTweets().get(0);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
	}

}
