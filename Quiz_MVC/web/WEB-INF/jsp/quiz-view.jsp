<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Application</title>
    </head>

    <body>
        
        <c:set var="first" scope="request" value="${requestScope.questions[0]}" />
        
        <c:if test="${first ne 'answers'}">
            <form action="${first + 1}.htm" method="post">
                <c:forEach var="item" items="${requestScope.questions}" begin="0" end="1">
                    ${item}<br>
                </c:forEach>
                <br/><br/>
                <c:forEach var="item" items="${requestScope.questions}" begin="2" end="6">
                    <input type='radio' name='page${first}' value='${item}' />${item}<br /><br>
                </c:forEach>

                <br/>
                <input type="submit" value ="Next" name = "button"/>
            </form>
        
        </c:if>
        <c:if test="${first == 'answers'}">
            <c:forEach var="answer" items="${requestScope.questions}">
                ${answer}<br><br/>
            </c:forEach>
        </c:if>
        
    </body>
</html>
