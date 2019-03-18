package com.controller;

import com.Bean.Movie;
import com.dao.Dao;
import com.validator.MovieValidator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Tanmayee Kalluri
 */
public class AddMovieController  extends SimpleFormController{

    public AddMovieController() {
        setCommandClass(Movie.class);
        setCommandName("movie");
        setSuccessView("SuccessPage");
        setFormView("addMovie");
       setValidator(new MovieValidator());
    }
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        Movie movie = (Movie) command;
        ModelAndView mv = new ModelAndView();
        Dao movieDao = (Dao) getApplicationContext().getBean("movieDao");
        int sucesssFlag= movieDao.addMovie(movie);
        if (sucesssFlag == 0) {
            mv = new ModelAndView(getSuccessView(), "message", "Error!");
        } else {
            mv = new ModelAndView(getSuccessView(), "message", "Movie added successfully!");
        }
        return mv;
    }

}
