<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>        
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Word Scrambler Start</title>
        <link rel="stylesheet" href="styles/main.css"/>
    </head>
    <body>        
        <div id="headerImg"><img class="headingImg" src="word-scrambler.svg" width="600"></div>        
        <div align="center">Congratulations! You win!<div>
        <form action="ScoresServlet" method="post">
            <input type ="hidden" name="action" value="add">
            <input type="hidden" name="action" value="add">        
            <label class="pad_top">Initials:</label>
            <input type="text" name="initials" value="${score.initials}" 
               required><br>
            <label class="pad_top">Final Score:</label>
            <input type="text" name="finalScore" value="${score.finalScore}" 
               required><br>
            <label class="pad_top">Final Time:</label>
            <input type="text" name="finalTime" value="${user.finalTime}"  
               required><br>        
            <label>&nbsp;</label>
            <input type="submit" value="" class="margin_left">
        </form>
        <div class="footer">
            Team++ (Jan Patrick Camaclang, Gregory Gonzalez, Faiga Revah, Ryan Westerhoff)
        </div>
    </body>
</html>
