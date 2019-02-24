/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.CsvDao;
import com.pojo.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author tankalluri
 */
public class CSVTagHandler extends SimpleTagSupport {

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CSVTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
        CsvDao cd = new CsvDao();
        List<File> rows= cd.getRows(message);
	out.println("<table border=1 align=\"center\">");
        out.println("<th>SalesOrderId</th>");
        out.println("<th>RevisionNumber</th>");
        out.println("<th>OrderDate</th>");
        out.println("<th>DueDate</th>");
        out.println("<th>ShipDate</th>");
        out.println("<th>Status</th>");
        out.println("<th>OnlineOrderFlag</th>");
        out.println("<th>SalesOrderNumber</th>");
        out.println("<th>PurchaseOrderNumber</th>");
        out.println("<th>AccountNumber</th>");
        out.println("<th>CustomerID</th>");
        out.println("<th>SalesPersonID</th>");
        out.println("<th>TerritoryID</th>");
        out.println("<th>BillToAddressID</th>");
        out.println("<th>ShipToAddressId</th>");
        out.println("<th>ShipMethodID</th>");
        out.println("<th>CreditCardID</th>");
        out.println("<th>CreditCardApprovalCode</th>");
        out.println("<th>SubTotal</th>");
        out.println("<th>TaxAmt</th>");
        out.println("<th>Freight</th>");
        out.println("<th>TotalDue</th>");
        out.println("<th>Comment</th>");
        out.println("<th>ModifiedDate</th>");
        
        for(File f : rows){
            out.println("<tr>");
            out.println("<td>"+f.getSalesOrderId()+"</td>");
            out.println("<td>"+f.getRevisionNumber()+"</td>");
            out.println("<td>"+f.getOrderDate()+"</td>");
            out.println("<td>"+f.getDueDate()+"</td>");
            out.println("<td>"+f.getShipDate()+"</td>");
            out.println("<td>"+f.getStatus()+"</td>");
            out.println("<td>"+f.getOnlineOrderFlag()+"</td>");
            out.println("<td>"+f.getSalesOrderNumber()+"</td>");
            out.println("<td>"+f.getPurchaseOrderNumber()+"</td>");
            out.println("<td>"+f.getAccountNumber()+"</td>");
            out.println("<td>"+f.getCustomerId()+"</td>");
            out.println("<td>"+f.getSalesPersonId()+"</td>");
            out.println("<td>"+f.getTerritory()+"</td>");
            out.println("<td>"+f.getBillToAddressId()+"</td>");
            out.println("<td>"+f.getShipToAddressId()+"</td>");
            out.println("<td>"+f.getShipMethodId()+"</td>");
            out.println("<td>"+f.getCreditCardId()+"</td>");
            out.println("<td>"+f.getCreditCardApprovalCode()+"</td>");
            out.println("<td>"+f.getSubTotal()+"</td>");
            out.println("<td>"+f.getTaxAmt()+"</td>");
            out.println("<td>"+f.getFreight()+"</td>");
            out.println("<td>"+f.getTotalDue()+"</td>");
            out.println("<td>"+f.getComment()+"</td>");
            out.println("<td>"+f.getModifiedDate()+"</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        } 
        catch (java.io.IOException ex) {
            throw new JspException("Error in CSVTagHandler tag", ex);
        }
    }
    
}