/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.Bean.Movie;
import com.dao.Dao;
import com.validator.MovieValidator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Tanmayee Kalluri
 */
public class SearchMovieController extends SimpleFormController{

    public SearchMovieController() {
        setCommandClass(Movie.class);
        setCommandName("movieSearch");
        setSuccessView("ShowMovies");
        setFormView("searchMovie");
       setValidator(new MovieValidator());
    }
    @Override
    protected ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        Movie movie = (Movie) command;
        ModelAndView mv = new ModelAndView();
        Dao movieDao = (Dao) getApplicationContext().getBean("movieDao");
        List<Movie>  movieDetails= movieDao.searchMovie(movie.getId());
            mv = new ModelAndView(getSuccessView(), "movieDetails", movieDetails);
        return mv;
    }
}
