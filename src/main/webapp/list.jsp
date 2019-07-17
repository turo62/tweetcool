<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.codecool.web.model.Tweet" %>
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
    <li><a href="index">Main page</a></li>
    <li><a href="index">Add new tweet</a></li>
</ul>

<div class="main">
    <h1>Tweetcool</h1>
    <div class="right">
            <h2>Sorted tweet list</h2> <br>
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
    <div class="left">
          <form action = "list" class="list" method = "GET">
            <table>
              <tr>
                <td>limit:</td><td><input type="number" name="limit" value="10"></input></td>
              </tr>
              <tr>
                <td>offset:</td><td><input type="number" name="offset" value="0"></input></td>
              </tr>
              <tr>
                <td>poster:</td><td><input type="text" name="poster"></input></td>
              </tr>
              <tr>
                <td>from:</td><td><input type="date" name="from" value="2019-07-06"></input></td>
              </tr>
            </table>
            <input type = "submit" value = "list" />
          </form>
    </div>
</div>

</body>
</html>


