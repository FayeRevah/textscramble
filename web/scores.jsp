<%--
score.jsp
Displays the top 10 highest scores
Author: Gregory Gonzalez, Team++
--%>

<!DOCTYPE html>
<html>
    <head>        
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
        <h1>Scores</h1>
        <table>
          <tr>
            <th>ID</th>
            <th>Initials</th>
            <th>Time</th>
            <th>High Score</th>
          </tr>
          <c:forEach var="score" items="${scores}">
          <tr>
            <td>${score.ID}</td>
            <td>${score.initials}</td>
            <td>${score.finalTime}</td>
            <td>${score.score}</td>
          </tr>
          </c:forEach>
        </table>
        <p><a href="Scores">Refresh</a></p>

    </body>
</html>