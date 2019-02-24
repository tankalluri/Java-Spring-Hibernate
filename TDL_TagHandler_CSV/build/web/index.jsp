<%-- Document   : index
    Created on : Feb 18, 2019, 2:30:45 PM
    Author     : tankalluri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "csv" uri = "WEB-INF/tlds/custom.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSV DATA</title>
    </head>
    <body>  
        <c:if test="${pageContext.request.isUserInRole('tanmayee_role')}">
        <csv:CSVTagHandler message="SalesOrder" ></csv:CSVTagHandler>
        </c:if>     
                
    </body>
</html>
