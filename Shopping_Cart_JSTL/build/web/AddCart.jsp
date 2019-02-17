<%-- 
    Document   : AddCart
    Created on : Feb 12, 2019, 11:19:46 PM
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
        <h1>Add Cart</h1>
        <c:forEach var="items" items="${sessionScope.cart}">
            <p>Item <b><c:out value="${items.getItem()}"></c:out></b> added successfully!</p>
        </c:forEach>
            <a href="http://localhost:8080/HW3_Part5/Books.jsp">Go back to Books page</a>
    </body>
</html>
