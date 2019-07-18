package com.codecool.web.service;

import com.codecool.web.model.Tweet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class tweetServiceTest {
    private TweetService testService = TweetService.getInstance();
    private Date testDate = new Date(1552136085000L);
    private  Tweet my1 = new Tweet("istyu", "szöveg1");
    private  Tweet my2 = new Tweet("istyu", "szöveg2");
    private  Tweet my3 = new Tweet("pisti", "szöveg3");
    
    @BeforeEach
    void setUp() {
        testService.addTweet(my1);
        testService.addTweet(my2);
        testService.addTweet(my3);
    }
    
    @Test
    void getTweets() {
        assertTrue(testService.getTweets().contains(my1) &&
                    testService.getTweets().contains(my2) &&
                    testService.getTweets().contains(my3));
    }
    
    @Test
    void getFiltered() {
        List<Tweet> testList = testService.getFiltered("istyu", testDate, 1, 2);
        assertTrue(testList.contains(my1));
        assertFalse(testList.contains(my2));
        assertFalse(testList.contains(my3));
    }
}
