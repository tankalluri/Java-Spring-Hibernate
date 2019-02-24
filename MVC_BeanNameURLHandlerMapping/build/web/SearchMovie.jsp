<%--
    Author     : tankalluri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <body>
        <form action="searchMovie.htm" method="post">
        <h1>Searching Movies</h1>
        <label>Keyword: </label> <input type="text" name="keyword"><br/><br/>
        <input type="radio" name="search" value="titleSearch"/>Search by Title<br/><br/>
        <input type="radio" name="search" value="actorSearch"/>Search by Actor<br/><br/>
        <input type="radio" name="search" value="actressSearch"/>Search by Actress<br/><br/>
        <input type="submit" value="Search Movies">
        </form>
    </body>
</html>
