<%-- 
    Document   : ResultPage
    Created on : Feb 10, 2019, 1:06:40 AM
    Author     : tankalluri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie</title>
    </head>
    <body>
        <table border='1'>
            <thead>
            <th>Title</th>
            <th>Actor</th>
            <th>Actress</th>
            <th>Genre</th>
            <th>Year</th>
        </thead>
        <tbody>
            <c:forEach var="movieResult" items="${requestScope.movieDetails}">
                <tr>
                    <td>
                        <c:out value="${movieResult.getTitle()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${movieResult.getActor()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${movieResult.getActress()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${movieResult.getGenre()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${movieResult.getYear()}"></c:out>
                    </td>
                </tr>
            </c:forEach>        
        </tbody>
    </table>
    </body>
</html>
