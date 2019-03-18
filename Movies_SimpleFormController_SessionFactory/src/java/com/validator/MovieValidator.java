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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required","Please fill the title");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actor", "actor.required","Please fill the actor");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actress", "actress.required","Please fill the actress");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gener", "gener.required","Please fill the genre");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "year.required","Please fill the year");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required","Movie ID is mandatory");
    }
    
}
