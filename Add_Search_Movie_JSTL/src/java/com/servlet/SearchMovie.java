/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.MoviesDao;
import com.pojo.Movie;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tankalluri
 */
public class SearchMovie extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        MoviesDao movie = new MoviesDao();
        RequestDispatcher requestDispatcher= getServletContext().getRequestDispatcher("/SearchMovie.jsp");
        String criteria= request.getParameter("search");
        String keyword= request.getParameter("keyword");
        List<Movie> movieDetails = null;
        if(criteria.equalsIgnoreCase("titleSearch"))
        movieDetails= movie.getMovies("title", keyword);
        
        else if(criteria.equalsIgnoreCase("actorSearch"))
         movieDetails= movie.getMovies("actor", keyword);  
        
        else if(criteria.equalsIgnoreCase("actressSearch"))
         movieDetails= movie.getMovies("actress", keyword);
        request.setAttribute("movieDetails", movieDetails);
        requestDispatcher= request.getRequestDispatcher("/ResultPage.jsp");
        requestDispatcher.forward(request, response);
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
