<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.Bean.Movie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
 <title></title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <c:set var="searchtext" value="${requestScope.searchContent}"/>
    <c:set var="SearchBy" value="${requestScope.searchBy}"/>
<div>
    <table border="1">
            <thead>
            <th>Movie Title</th>
            <th>Lead Actor</th>
            <th>Lead Actress</th>
            <th>Genre</th>
            <th>Year</th>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.movieDetails}" var="movie">
                <tr>
                    <td>${movie.getTitle()}</td>
                    <td>${movie.getActor()}</td>
                    <td>${movie.getActress()}</td>
                    <td>${movie.getGenre()}</td>
                    <td>${movie.getYear()}</td>
            </c:forEach>
            </tbody>
        </table>
    <a href="index.htm">Back</a>
</form>
 </div>
 </body>
</html>
