/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextScramble;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author janpa
 */
public class ScoresServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/index.html";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "add";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("add")) {
            // get parameters from the request
            int finalScore = Integer.parseInt(request.getParameter("finalScore"));
            int finalTime = Integer.parseInt(request.getParameter("finalTime"));
            String initials = request.getParameter("initials");

            // store data in score object
            Score score = new Score();
            score.setInitials(initials);
            score.setScore(finalScore);
            score.setFinalTime(finalTime);

            url = "/scores.jsp";
            ScoreDB.insert(score);
            List<Score> scores = ScoreDB.selectScores();            
            request.setAttribute("scores", scores);
           
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }    
}
