/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.quiz.pojo;

import com.neu.quiz.pojo.Question;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aditi
 */
public class ListOfQuestions {
    
    private List<Question> questions;

    public ListOfQuestions() {
        this.questions = new ArrayList<Question>();
        addQuestion();
    }
    
    
    public void addQuestion(){
        Question q1 = new Question();
        q1.setQuestionNumber(1);
        q1.setQuestion("Question 1: Which method doesn't exist in HttpServlet class");
        List<String> options = new ArrayList<>();
        options.add("Post");
        options.add("Init");
        options.add("Get");
        options.add("Option");
        q1.setOptions(options);
        
        
        Question q2 = new Question();
        q2.setQuestionNumber(1);
        q2.setQuestion("Question 1: Which method doesn't exist in HttpServlet class");
        List<String> options2 = new ArrayList<>();
        options2.add("Get");
        options2.add("Option");
        options2.add("Post");
        options2.add("Init");
        q2.setOptions(options2);
        
        Question q3 = new Question();
        q3.setQuestionNumber(1);
        q3.setQuestion("Question 1: Which method doesn't exist in HttpServlet class");
        List<String> options3 = new ArrayList<>();
        options3.add("Option");
        options3.add("Get");
        options3.add("Init");
        options3.add("Post");
        q3.setOptions(options3);
        
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
    
}
