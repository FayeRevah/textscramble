<%-- 
    Document   : TextScramble
    Created on : Jun 13, 2017, 1:50:30 PM
    Author     : West
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script id="countDownTimer">
        // initalize global timer
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
            
            totalTime++;

        }, 1000);
        
        function getTotalTime(){
            return totalTime;
        }
    </script>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Word Scrambler</title>
        <link rel="stylesheet" href="styles/main.css"/>
    </head>
    <body>
        <div id="headerImg"><img class="headingImg" src="word-scrambler.svg" width="600"></div>
        <p id="timer"></p>
        <form action="TextScrambleServlet">
            <p>Here is a scrambled word. Guess what it says.</p>
            <p id="word"><strong>word</strong><p>
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
