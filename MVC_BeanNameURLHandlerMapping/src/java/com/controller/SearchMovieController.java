/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.MoviesDao;
import com.pojo.Movie;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author tankalluri
 */
public class SearchMovieController extends AbstractController {
    
    public SearchMovieController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mv= null;
        MoviesDao movie = new MoviesDao();
        try{
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
        mv= new ModelAndView("ResultPage");
        }
        catch(Exception e){
        mv= new ModelAndView("FailPage");  
        }
        return mv;
    }
    
}
