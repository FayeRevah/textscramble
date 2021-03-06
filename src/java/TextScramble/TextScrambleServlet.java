/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextScramble;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author West
 */
public class TextScrambleServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        Game game = (Game)session.getAttribute("game");
        int result = 0;
        if (game==null){
            // this must be a new session, so we will start a new Game
            System.out.println("Text Scramble.  New game.");
            game = new Game();  // start new game.
            result=0;
        } else {
           String input = request.getParameter("guess");
           String timeStr = request.getParameter("timeVar");
           if(timeStr == null)
               timeStr = "0";
           int time = Integer.valueOf(timeStr);
           System.out.println("Scramble. guess="+input);
               if (input==null) {
               result=0;
           } else
           {
              result = game.playGame(input, time);
           }
        }
        System.out.println("Scramble Result="+result+"\n");
       
        if(result == 0 || result == 1)//either no input or a new game
        {
            session.setAttribute("game", game);
            request.setAttribute("word", game.getScrambledWord());
            request.setAttribute("correct", game.getCorrect());
            request.setAttribute("incorrect", game.getIncorrect());
            request.setAttribute("timerValue", game.getTime());
            getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        }
        if(result == 2)//game won
        {
            session.invalidate();
            request.setAttribute("finalTime", Integer.valueOf(request.getParameter("timeVar")));
            request.setAttribute("finalScore", game.getScore());
            getServletContext().getRequestDispatcher("/win.jsp").forward(request,response);
        }
        if(result == 3)//game lost
        {
            session.invalidate();
            getServletContext().getRequestDispatcher("/lose.jsp").forward(request,response);
        }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
