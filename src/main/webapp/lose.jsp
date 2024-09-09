<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="jakarta.servlet.http.HttpServlet"
%>
<html>
<head>
<link rel="stylesheet" href="style.css">
    <title>Ты проиграл!

    </title>
</head>
<body>
<p>
    ${question}
</p>
<h1>Придётся еще раз сыграть</h1>
 <script>
    setTimeout(function(){
        location.href = '${pageContext.request.contextPath}/games';
    }, 2000);
    </script>




</body>
</html>