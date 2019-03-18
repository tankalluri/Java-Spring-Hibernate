/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Tanmayee Kalluri
 */
public class QuizController extends AbstractController {
    
    public QuizController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String uri = request.getRequestURI();
        String q;
        String answer;
        ArrayList<String> questions = new ArrayList<String>();
        HttpSession session = request.getSession();
        
        if (uri.endsWith("1.htm"))
        {
            q = "1";
            questions.clear();
            questions.add(q);
            questions.add("Which method doesn't exist in HttpServlet class?");
            questions.add("post");
            questions.add("init");
            questions.add("get");
            questions.add("option");
            
        } else if (uri.endsWith("2.htm"))
        {
            q = "2";
            answer = request.getParameter("page1");
            System.out.println("ABSWER "+answer);
            session.setAttribute("page1ans", answer);
            questions.clear();
            questions.add(q);
            questions.add("Which HTTP method is idempotent ?");
            questions.add("post");
            questions.add("init");
            questions.add("get");
            questions.add("option");
        }else if (uri.endsWith("3.htm"))
        {
            q = "3";
            answer = request.getParameter("page2");
            session.setAttribute("page2ans", answer);
            questions.clear();
            questions.add(q);
            questions.add("Which method is called when client request comes?");
            questions.add("post");
            questions.add("init");
            questions.add("get");
            questions.add("option");
        } else if (uri.endsWith("4.htm"))
        {
            q = "answers";
            questions.clear();
            questions.add(q);
            String quiz1 = (String) session.getAttribute("page1ans");
            String quiz2 = (String) session.getAttribute("page2ans");
            answer = request.getParameter("page3");
            questions.add(quiz1);
            questions.add(quiz2);
            questions.add(answer);
        }else {
            return new ModelAndView("redirect:question/1.htm");
        }
        
        return new ModelAndView("quiz-view", "questions", questions);
    }
    
}
