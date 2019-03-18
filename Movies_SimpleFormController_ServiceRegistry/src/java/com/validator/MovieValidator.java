package com.validator;

import com.Bean.Movie;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Tanmayee Kalluri
 */
public class MovieValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Movie.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required","Please enter title");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actor", "actor.required","Please enter actor");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actress", "actress.required","Please enter actress");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "genre.required","Please enter genre");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "year.required","Please enter year");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required","Please enter movie ID");
    }
    
}
