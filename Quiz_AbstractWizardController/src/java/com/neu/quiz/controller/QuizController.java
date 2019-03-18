/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.quiz.controller;

import com.neu.quiz.pojo.ListOfQuestions;
import com.neu.quiz.pojo.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;



/**
 *
 * @author aditi
 */
public class QuizController extends AbstractWizardFormController{

     
     @Override
     protected Object formBackingObject(HttpServletRequest request) throws Exception{
         return new ListOfQuestions();
     }
     
     @Override
     protected void validatePage(Object command, Errors errors,int page) {
     
     }
    
    @Override
    protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException be) throws Exception {
        
       ModelAndView mv = null;
       ListOfQuestions listofQuestions = (ListOfQuestions) command;
       
       String uri = request.getRequestURI();
       Question question = null;
       
       if (uri.endsWith("1.htm")) {
           question = listofQuestions.getQuestions().get(0);
       } 
       else if (uri.endsWith("2.htm")) { 
           question = listofQuestions.getQuestions().get(1);
       }
       else if (uri.endsWith("3.htm")) {
           question = listofQuestions.getQuestions().get(2);
       }
       else if (uri.endsWith("4.htm")){
           //display answers
           System.out.println("I am in answers");
       }
       else {
       
           //first time user is visiting, so display the 1st question
            listofQuestions = new ListOfQuestions();
            
            return new ModelAndView("redirect:question/1.htm");
       }
       return new ModelAndView("quiz-view", "question", question);
    }

   @Override
   protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response,
                         Object command, BindException errors) throws Exception {
       //return cancellation view
       return new ModelAndView("cancelation-view");
   }
    
}
