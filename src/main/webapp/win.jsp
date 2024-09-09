
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="jakarta.servlet.http.HttpServlet"
%>
<html>
<head>
<link rel="stylesheet" href="style.css">
    <title>Ты выиграл,поздравляем!
    </title>
</head>
<body>
<p>
    ${question}
</p>
<h1>Не желаещь сыграть еще раз?</h1>

<form action="${pageContext.request.contextPath}/games" method="get" >
     <input class="btn btn-primary btn-lg" type="submit"   name="buttonYes" value="Да" >
  </form>
  <form action="${pageContext.request.contextPath}/index.jsp" method="get" >
       <input class="btn btn-primary btn-lg" type="submit"   name="buttonNo" value="Нет" >
    </form>

</body>
</html>