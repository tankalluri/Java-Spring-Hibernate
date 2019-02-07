package com.assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tankalluri
 */
@WebServlet(name = "BooksDb", urlPatterns = {"/BooksDb"})
public class BooksDb extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String countOfBoosk =request.getParameter("booksCount");
        int count=Integer.parseInt(countOfBoosk);        
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BooksDb</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"post\" action=\"SuccessPage\">");
            out.println("<table>");
            out.println("<th>ISBN</th>");
            out.println("<th>Book Title</th>");
            out.println("<th>Authors</th>");
            out.println("<th>Price</th>");
            while(count!=0){
                out.print("<tr>");
                out.println("<td><input type=\"input\" name=\"isbn\"/></td>");
                out.println("<td><input type=\"input\" name=\"title\"/></td>");
                out.println("<td><input type=\"input\" name=\"author\"/></td>");
                out.println("<td><input type=\"input\" name=\"price\"/></td>");
                out.print("</tr>");
                count--;
            }
            out.println("</table>");
            out.println("<input type=\"submit\" value=\"Add Books\"/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
