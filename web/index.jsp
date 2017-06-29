<%-- 
    Document   : TextScramble
    Created on : Jun 13, 2017, 1:50:30 PM
    Author     : West
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Word Scrambler</title>
        <link rel="stylesheet" href="styles/main.css"/>
    </head>
    <body>
        <div id="headerImg"><img class="headingImg" src="word-scrambler.svg" width="600"></div>
        <form action="TextScrambleServlet">
            <p>Here is a scrambled word. Guess what it says.</p>
            <p id="word"><strong><%= request.getAttribute("word")%></strong><p>
            <div class="input"><input class="guessInput" type="text" name="guess" placeholder="Guess"><input class="submitBtn" type="submit"  value="Submit"></div>
        </form>
        <form action="Scores">
            <input class="submitBtn" type="submit"  value="High Scores">
        </form>
        <div class="footer">
            Team++ (Jan Patrick Camaclang, Gregory Gonzalez, Faiga Revah, Ryan Westerhoff)
        </div>
    </body>
</html>
