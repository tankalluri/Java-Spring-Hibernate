package com.assignment.part7;

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
@WebServlet(name = "AddNewMovie", urlPatterns = {"/AddNewMovie"})
public class AddNewMovie extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String title= request.getParameter("movieTitle");   
        String actor=request.getParameter("actor");
        String actress= request.getParameter("actress");
        String genre=request.getParameter("genre");
        String year=request.getParameter("year");
        
        
        java.sql.Connection connection;
        PreparedStatement stmt;
  
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "root");
            stmt= connection.prepareStatement("insert into movies values (?,?,?,?,?)");
            stmt.setString(1, title);
            stmt.setString(2, actor);
            stmt.setString(3, actress);
            stmt.setString(4, genre);
            stmt.setInt(5, Integer.parseInt(year));
             stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddNewMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title></title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Movie Successfully added!</h1>");
            out.println("<a href=\"http://localhost:8080/Assignment2_Part7/\">Click here to go back to the home page</a>");
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
