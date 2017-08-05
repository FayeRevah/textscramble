<%-- 
    Document   : TextScramble
    Created on : Jun 13, 2017, 1:50:30 PM
    Author     : West
--%>

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
        <script id="countDownTimer">
            // initalize global timer
            //var totalTime = document.getElementById('timeVar').getAttribute(value);
            var totalTime = 0;
            // Update the count down every 1 second
            var tick = setInterval(function () {

                // Time calculations for days, hours, minutes and seconds));
                var hours = Math.floor(totalTime / 3600);
                var minutes = (Math.floor(totalTime / 60)) % 60;
                var seconds = totalTime % 60;

                // Display the result in the element with id="timer"
                document.getElementById("timer").innerHTML = hours + "h "
                        + minutes + "m " + seconds + "s ";
                document.getElementById('timeVar').setAttribute('value', totalTime);
                totalTime++;

            }, 1000);
        </script>
        <div id="headerImg"><img class="headingImg" src="word-scrambler.svg" width="600"></div>
        <form action="TextScrambleServlet">
            <p id="timer"></p>
            <input type="hidden" name="timeVar" id="timeVar" value = ""/>
            <table style="width:100%;">
                <tr>
                  <th style="background-color: #92c9d4;"> <font style="color: black; font-family: 'Gill Sans';">Correct Guesses: <%= request.getAttribute("correct")%>/5</th>
                  <th style="background-color: #92c9d4;"> <font style="color: black; font-family: 'Gill Sans';">Incorrect Guesses: <%= request.getAttribute("incorrect")%>/10</th>
                </tr>
            </table>
            <p>Here is a scrambled word. Guess what it says.</p>
            <p id="word"><strong><%= request.getAttribute("word")%></strong><p>
            <div class="input"><input class="guessInput" type="text" name="guess" placeholder="Guess"><input class="submitBtn" type="submit"  value="Submit"></div>
        </form>
        <div align="center"><form action="Scores">
                <input class="submitBtn" type="submit"  value="High Scores">
            </form></div>
        <div class="footer">
            Team++ (Jan Patrick Camaclang, Gregory Gonzalez, Faiga Revah, Ryan Westerhoff)
        </div>
    </body>
</html>
