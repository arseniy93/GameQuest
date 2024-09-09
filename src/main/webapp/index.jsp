<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Хотите поиграть?" %>
</h1>
<br/>
<a href="/games">Да </a>
<a href="${pageContext.request.contextPath}/LoseGame.jsp"> Нет</a>
<%--<p>Today <%= new java.util.Date() %></p>--%>
</body>
</html>