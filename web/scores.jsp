<%--
score.jsp
Displays the top 10 highest scores
Author: Gregory Gonzalez, Team++
--%>

<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Word Scrambler</title>
        <link rel="stylesheet" href="styles/main.css"/>
    </head>
    <body>
        <div id="headerImg"><img class="headingImg" src="word-scrambler.svg" width="600"></div>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
        <p>High Scores</p>
        <table align="center">
          <tr>
            <th>Initials</th>
            <th>Time</th>
            <th>Score</th>
          </tr>
          <c:forEach var="score" items="${scores}">
          <tr>
            <td>${score.initials}</td>
            <td>${score.finalTime}</td>
            <td>${score.score}</td>
          </tr>
          </c:forEach>
        </table>
        <div style="text-align: center;">
            <form action="TextScrambleServlet">
                <button class="submitBtn" type="submit"  value="Play Game">Play Game</button>
            </form>
        </div>
        <div class="footer" style="position: absolute">
            Team++ (Jan Patrick Camaclang, Gregory Gonzalez, Faiga Revah, Ryan Westerhoff)
        </div>
    </body>
</html>
