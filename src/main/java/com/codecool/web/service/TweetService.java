package com.codecool.web.service;

import com.codecool.web.model.Tweet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public final class TweetService {
    private List<Tweet> tweets;
    private static TweetService myInstance = new TweetService();
    
    public TweetService() {
        tweets = new ArrayList<>(Arrays.asList(
            new Tweet("pityu", "Ez becenév"),
            new Tweet("isti", "Ez is becenév")));
    }
    
    public static TweetService getInstance() {
        return myInstance;
    }
    
    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }
    
    public List<Tweet> getTweets() {
        return tweets;
    }
}
