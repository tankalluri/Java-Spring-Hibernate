<%-- 
    Document   : addMovie
    Created on : Feb 4, 2019, 12:32:22 AM
    Author     : tankalluri
--%>

<%@page import="com.assignment.part7.AddNewMovie"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1>Please enter the details below:</h1>
        <form action="AddNewMovie" method="post">
            <label>Movie Title :</label>  <input type="text" name="movieTitle"><br /><br/>
            <label>Lead Actor :</label>  <input type="text" name="actor"><br /><br/>
            <label>Lead Actress :</label>  <input type="text" name="actress"><br /><br/>
            <label>Genre :</label>  <input type="text" name="genre"><br /><br/>
            <label>Year :</label> <input type="text" name="year"><br /><br/><br/>
            <input type="submit" value="Add Movie">
        </form>
    </body>
</html>
