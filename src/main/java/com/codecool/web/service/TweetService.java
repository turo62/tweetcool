package com.codecool.web.service;

import com.codecool.web.model.Tweet;

import java.text.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TweetService {
    private static int DEFAULTLIMIT = 20;
    private List<Tweet> tweets;
    private static TweetService myInstance = new TweetService();
    private DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    
    private TweetService() {
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
    
    public List<Tweet> getFiltered(String poster, Date date, int offset, int limit) {
        List<Tweet> allTweets = getTweets();
        List<Tweet> posterFiltered = new ArrayList<>();
        List<Tweet> dateFiltered = new ArrayList<>();
        List<Tweet> filteredTweets = new ArrayList<>(tweets);
        
        if (poster == null) {
            posterFiltered = allTweets;
        } else {
            posterFiltered = filterByPoster(allTweets, poster);
        }
        
        if (date == null | date.equals("")) {
            dateFiltered = posterFiltered;
        } else {
            dateFiltered = filterByDate(posterFiltered, date);
        }
        
        if (offset + limit == 0) {
            filteredTweets = dateFiltered;
        } else {
            filteredTweets = filterByLimit(dateFiltered, limit, offset);
        }
        return filteredTweets;
    }
    
    private List<Tweet> filterByPoster(List<Tweet> actTweet, String poster) {
        List<Tweet> byPoster = new ArrayList<>();
        
        for (Tweet t: tweets) {
            if (t.getPoster().equals(poster)) {
                byPoster.add(t);
            }
        }
        
        return byPoster;
    }
    
    private List<Tweet> filterByDate(List<Tweet> tweets, Date date) {
        List<Tweet> byDate = new ArrayList<>();
    
        for (Tweet t: tweets) {
            if (t.getDate().after(date)) {
                byDate.add(t);
            }
        }
        
        return byDate;
    }
    
    private List<Tweet> filterByLimit(List<Tweet> tweets, int limit, int offset) {
        int counter;
        List<Tweet> limitFiltered = new ArrayList<>();
        if (limit + offset > tweets.size()) {
            counter = 0;
        } else {
            counter = tweets.size() - limit - offset;
        }
        
        for (int i = counter; i < tweets.size() - offset; i++) {
            limitFiltered.add(tweets.get(i));
        }
        
        return limitFiltered;
    }
}
