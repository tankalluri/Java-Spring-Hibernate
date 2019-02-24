/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.MoviesDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author tankalluri
 */
public class AddMovieController extends AbstractController {
    
    public AddMovieController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mv= null;
        MoviesDao movie = new MoviesDao();
         try{
        if(request.getParameter("movieTitle").equalsIgnoreCase("")|| request.getParameter("actor").equalsIgnoreCase("")|| request.getParameter("actress").equalsIgnoreCase("")|| request.getParameter("genre").equalsIgnoreCase("")|| request.getParameter("year").equalsIgnoreCase(""))
            throw new Exception("Please enter values!");
        else{
        String title= request.getParameter("movieTitle");
        String actor= request.getParameter("actor");
        String actress= request.getParameter("actress");
        String genre= request.getParameter("genre");
        int year= Integer.parseInt(request.getParameter("year"));
        movie.addMovie(title, actor, actress, genre, year);
        mv= new ModelAndView("SuccessPage");}
        }
       catch(Exception e){
        mv= new ModelAndView("FailPage");
        System.out.println("Exception occurred");
    }
        return mv;
    }
    
}
