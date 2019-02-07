<%-- 
    Document   : Books
    Created on : Feb 4, 2019, 3:09:31 PM
    Author     : tankalluri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Storage</title>
    </head>
    <body>
        <form method="post" action="BooksDb">
                <h1>How many books do you want to add?</h1>
                <input type="input" name="booksCount"/>
                <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
