/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.pojo.BeanItems;
import com.pojo.Items;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tankalluri
 */
public class Cart extends HttpServlet {

    List<BeanItems> cartItems = null;
    HttpSession session;
    Items item=new Items();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       session= request.getSession();
        RequestDispatcher dispatcher;
        String itemName[];
       if(session.isNew()){
           
       }
       else{
           String operation= request.getParameter("operation");
           if(operation.equalsIgnoreCase("addItemToCart")){
               itemName=request.getParameterValues("orders");
               for(int i=0;i<itemName.length;i++)
               cartItems =item.addItems(itemName[i]);
               session.setAttribute("cart", cartItems);
               dispatcher=getServletContext().getRequestDispatcher("/AddCart.jsp");
               dispatcher.forward(request, response);
           }
           else if(operation.equalsIgnoreCase("viewCartItems")){
               dispatcher=getServletContext().getRequestDispatcher("/ViewCart.jsp");
               dispatcher.forward(request, response);
           }
            if (operation.equalsIgnoreCase("deleteFromCart")){
                String itemToRemove= request.getParameter("item");
                cartItems=item.removeItem(itemToRemove);
                session.setAttribute("cart", cartItems);
               dispatcher=getServletContext().getRequestDispatcher("/DeleteCart.jsp");
               dispatcher.forward(request, response);
           }
       }
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
