<%-- 
    Document   : ViewCart
    Created on : Feb 12, 2019, 11:20:16 PM
    Author     : tankalluri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>View Cart</h1>
        <c:forEach var="items" items="${sessionScope.cart}">
        <form action="Cart?operation=deleteFromCart" method="post"> 
        <input type='hidden' name='item' value='${items.getItem()}'/>
        <p><c:out value="${items.getItem()}"></c:out>&nbsp;&nbsp;<input type='submit' value='Delete'/></p>
        </form>
        </c:forEach>
        <a href="http://localhost:8080/HW3_Part5/">Go back to shopping</a>
    </body>
</html>