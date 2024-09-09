<%--
  Created by IntelliJ IDEA.
  User: arsen
  Date: 24.07.2024
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="jakarta.servlet.http.HttpServlet"
%>
<%

    String gotAnswer = "";
    String error = "";
    int numberOfQuestion = 1;

%>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Game</title>
</head>
<body>
<p>
<h1>Правила игры: нужно выбирать наиболее логичный ответ для того, чтобы пройти игру.</h1>
</p>
<p>
    ${question}
</p>


<legend>Выберете ответ:</legend>
<%--${pageContext.request.contextPath}/games--%>
<div class="container mt-5">
    <form action="${pageContext.request.contextPath}/games" method="post">
        <div class="form-check">
            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1"
                   property="notify" value="true" required>
            <label class="form-check-label" for="flexRadioDefault1">
                ${answer1}
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2"
                   property="notify" value="false" required>
            <label class="form-check-label" name="label2" for="flexRadioDefault2" value="${answer2}">
                ${answer2}
            </label>
        </div>
        <div>

        </div>


        <%

            if ((request.getParameter("button") != null) && (request.getParameter("flexRadioDefault") != null)) {
                error = " ";
                request.setAttribute("error", error);
                if (request.getParameter("flexRadioDefault").equals("true")) {//можно было тут добавить проверку окончания игры по true false
                    request.getParameter("flexRadioDefault");//up button
                } else if (request.getParameter("flexRadioDefault").equals("false")) {
                    request.getParameter("flexRadioDefault");//dawn button
                }
            }
        %>
        <input class="btn btn-primary btn-lg" type="submit" name="button" value="Ответить">
    </form>
    <input type="hidden" name="flag0" value="0">

    <h1>${error}</h1><br>
    <h1> Число выигрышей: ${win}</h1><br>
    <h1> Число проигрошей: ${lose}</h1><br>

</body>
</html>
