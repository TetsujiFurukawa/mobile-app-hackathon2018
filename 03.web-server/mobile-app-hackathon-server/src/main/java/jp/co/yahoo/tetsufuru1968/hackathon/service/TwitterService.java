package jp.co.yahoo.tetsufuru1968.hackathon.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Service
@AllArgsConstructor
public class TwitterService {

	public static String HASH_TAG = "#test";
	//	public static String HASH_TAG="@spajam";

	public void tweetGotMoney(String tweet, String currency_id) throws TwitterException {
		// ツイートする
		Twitter twitter = TwitterFactory.getSingleton();

//		StatusUpdate statusUpdate = new StatusUpdate(tweet + "\n" + HASH_TAG);

		String statusUpdate=tweet + "\n" + HASH_TAG;
//		statusUpdate.setMedia(new File("./src/main/resources/serverImages/" + currency_id + ".png"));
		twitter.updateStatus(statusUpdate);

	}
}
