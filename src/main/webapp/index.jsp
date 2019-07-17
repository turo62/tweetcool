<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.codecool.web.model.Tweet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css" type="text/css">
    <title>Tweetcool</title>
</head>

<body>
<ul class="navbar">
    <li><a href="index">Home page</a></li>
    <li><a href="list?offset=0&limit=0&from=2019-07-06">List sorted tweets</a></li>
</ul>

<div class="main">
    <h1>Welcome to Tweetcool!</h1>
    <div class="right">
        <h2>Type your Tweet!</h2>
        <form action = "" method = "POST">
            Your name: <input class = "name" type = "text" name = "poster"> <br> <br>
            Your tweet: <br><textarea class = "content" name = "content"></textarea><br>
            <input type = "submit" value = "Submit" />
        </form>

        <h2>Tweet list</h2>
        <% List<Tweet> tweets = new ArrayList<>(); %>
        <% if (request.getAttribute("tweets") != null) { %>
            <% tweets.addAll((List<Tweet>)request.getAttribute("tweets")); %>
        <% } %>
        <% if (tweets.size() > 0) { %>
            <% for (Tweet tweet : tweets) { %>
            <p><i><%= tweet.getDate() %><br>
            <%= tweet.getPoster() %></i>: <%= tweet.getContent() %></p>
            <% } %>
        <% } %>
    </div>
</div>
</body>
</html>
