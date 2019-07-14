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
    <li><a href="index.jsp">Home page</a></li>
    <li><a href="list.html">List sorted tweets</a></li>
    <li><a href="listall.html">List all recent tweets</a></li>
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
    </div>
</div>
</body>
</html>
