<%-- 
    Document   : Result
    Created on : Feb 10, 2019, 2:25:09 AM
    Author     : tankalluri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<jsp:useBean id="file" class="com.pojo.File" scope="session"></jsp:useBean>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSV Page</title>
    </head>
    <body>
    <table border='1'>
    <thead>
    <th>Sales Order Id</th>
    <th>Revision Number</th>
    <th>Order Date</th>	
    <th>Due Date</th>
    <th>Ship Date</th>
    <th>Status</th>
    <th>Online Order Flag</th>
    <th>Sales Order Number</th>
    <th>Purchase Order Number</th>
    <th>Account Number</th>
    <th>Customer ID</th>
    <th>Sales Person ID</th>
    <th>Territory ID</th>
    <th>Bill To Address ID</th>
    <th>Ship To Address Id</th>
    <th>Ship Method ID</th>
    <th>Credit Card ID</th>
    <th>Credit Card Approval Code</th>
    <th>Sub Total</th>
    <th>Tax Amt</th>
    <th>Freight</th>
    <th>Total Due</th>
    <th>Comment</th>
    </thead>
    <tbody>
               <c:forEach var="row" items="${requestScope.rows}">
                    <tr>
                       <td><c:out value="${row.getSalesOrderId()}"></c:out></td>
                       <td><c:out value="${row.getRevisionNumber()}"></c:out></td>
                       <td><c:out value="${row.getOrderDate()}"></c:out></td>
                       <td><c:out value="${row.getDueDate()}"></c:out></td>
                       <td><c:out value="${row.getShipDate()}"></c:out></td>
                 
                       <td><c:out value="${row.getStatus()}"></c:out></td>
                   
                       <td><c:out value="${row.getOnlineOrderFlag()}"></c:out></td>
                  
                       <td><c:out value="${row.getSalesOrderNumber()}"></c:out></td>
                
                       <td><c:out value="${row.getPurchaseOrderNumber()}"></c:out></td>
               
                       <td><c:out value="${row.getCustomerId()}"></c:out></td>
                
                       <td><c:out value="${row.getSalesPersonId()}"></c:out></td>
                
                       <td><c:out value="${row.getTerritory()}"></c:out></td>
               
                       <td><c:out value="${row.getBillToAddressId()}"></c:out></td>
                 
                       <td><c:out value="${row.getModifiedDate()}"></c:out></td>
               
                       <td><c:out value="${row.getShipToAddressId()}"></c:out></td>
                  
                       <td><c:out value="${row.getShipMethodId()}"></c:out></td>
                       <td><c:out value="${row.getCreditCardId()}"></c:out></td>
                       <td><c:out value="${row.getCreditCardApprovalCode()}"></c:out></td>
                       <td><c:out value="${row.getSubTotal()}"></c:out></td>
                       <td><c:out value="${row.getTaxAmt()}"></c:out></td>
                        <td><c:out value="${row.getFreight()}"></c:out></td>
                        <td><c:out value="${row.getTotalDue()}"></c:out></td>
                        <td><c:out value="${row.getComment()}"></c:out></td>
                    </tr>
               </c:forEach>
    </tbody>
    </table>
    </body>
</html>
