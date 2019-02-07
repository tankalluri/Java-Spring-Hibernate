package com.assignment.part7;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet(name = "DisplayMovies", urlPatterns = {"/DisplayMovies"})
public class DisplayMovies extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String criteria= request.getParameter("search");
        System.out.println("Selected box:"+criteria);
        String searchCriteria=request.getParameter("keyword");
        System.out.println("Value typed:"+searchCriteria);
        String title1 = null,actor1 = null,actress1 = null, genre1 = null; int year = 0;
        
        java.sql.Connection connection = null;
        PreparedStatement stmt;
        ResultSet rs;
  
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "root");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddNewMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(criteria.equalsIgnoreCase("actorSearch")){
            try {
                stmt=connection.prepareStatement("select * from movies where actor like ?");
                stmt.setString(1, '%'+searchCriteria+'%');
                rs=stmt.executeQuery();
                while(rs.next()){
                   title1= rs.getString(1);
                   actor1= rs.getString(2);
                   actress1= rs.getString(3);
                   genre1= rs.getString(4);
                   year =rs.getInt(5);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DisplayMovies.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(criteria.equalsIgnoreCase("actressSearch")){
            try {
                stmt=connection.prepareStatement("select * from movies where actress like ?");
                stmt.setString(1, '%'+searchCriteria+'%');
                rs=stmt.executeQuery();
                while(rs.next()){
                   title1= rs.getString(1);
                   actor1= rs.getString(2);
                   actress1= rs.getString(3);
                   genre1= rs.getString(4);
                   year =rs.getInt(5);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DisplayMovies.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(criteria.equalsIgnoreCase("titleSearch")){
            try {
                stmt=connection.prepareStatement("select * from movies where title like ?");
                stmt.setString(1, '%'+searchCriteria+'%');
                rs=stmt.executeQuery();
                while(rs.next()){
                   title1= rs.getString(1);
                   actor1= rs.getString(2);
                   actress1= rs.getString(3);
                   genre1= rs.getString(4);
                   year =rs.getInt(5);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DisplayMovies.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Search Results</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>You searched for -->"+searchCriteria+"</h1>");
            out.println("<h1><u>Here are the search results</u></h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>Movie Title:</td>");
            out.println("<td>"+title1+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Lead Actor:</td>");
            out.println("<td>"+actor1+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Lead Actress:</td>");
            out.println("<td>"+actress1+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Genre:</td>");
            out.println("<td>"+genre1+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Year:</td>");
            out.println("<td>"+year+"</td>");
            out.println("</tr>");
            out.println("</table>");
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
