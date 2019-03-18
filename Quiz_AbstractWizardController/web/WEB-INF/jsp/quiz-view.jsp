<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        
        <c:set var="questionWithOptions" scope="request" value="${requestScope.question}" />
        
       
        <form action="${questionWithOptions.questionNumber + 1}.htm" method="post">
            <c:out value="${questionWithOptions.question}" />
            <c:forEach var="item" items="${questionWithOptions.options}">
                 <input type='radio' name='page${questionWithOptions.questionNumber}' value='${item}' />${item}<br /><br>
            </c:forEach>
        
            <br/>
            <input type="submit" value ="Next" name = "button"/>
        </form>
        
        
        
        
    </body>
</html>
