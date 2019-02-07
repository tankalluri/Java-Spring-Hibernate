/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@WebServlet(name = "SuccessPage", urlPatterns = {"/SuccessPage"})
public class SuccessPage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String isbn[]= request.getParameterValues("isbn");   
        String title[]=request.getParameterValues("title");
        String author[]= request.getParameterValues("author");
        String price[]=request.getParameterValues("price");
        System.out.println("length "+isbn.length);
        System.out.println("book isbn "+isbn[0]);
        System.out.println("book title "+title[0]);
        System.out.println("book author "+author[0]);
        System.out.println("book price "+price[0]);

        java.sql.Connection connection = null;
        PreparedStatement stmt = null;
         int rec = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "root");
            for(int i=0;i<isbn.length;i++){
            stmt= connection.prepareStatement("insert into books values (?,?,?,?)");
            stmt.setString(1, isbn[i]);
            stmt.setString(2, title[i]);
            stmt.setString(3, author[i]);
            stmt.setInt(4, Integer.parseInt(price[i]));
             stmt.executeUpdate();
             rec++;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BooksDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SuccessPage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+rec+" books added to DB successfully</h1>");
            out.println("<a href=\"http://localhost:8080/ServletAssignment/Books.jsp\">Click here to back to Home Page!</a>");
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
