package com.codecool.web.servlet;

import com.codecool.web.model.Tweet;
import com.codecool.web.service.TweetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"", "/index"})
public class TweetServlet extends HttpServlet {
    
    private final TweetService myService = TweetService.getInstance();
    private List<Tweet> tweets = myService.getTweets();
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tweets", tweets);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String poster = req.getParameter("poster");
        String content = req.getParameter("content");
        myService.addTweet(new Tweet(req.getParameter("poster"), req.getParameter("content")));
        doGet(req, resp);
    }
}
