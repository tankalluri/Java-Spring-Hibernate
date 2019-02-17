<%-- 
    Document   : Books
    Created on : Feb 11, 2019, 5:40:58 PM
    Author     : tankalluri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Shopping Cart</title>
</head>
<body>
    <form action = 'Cart?operation=addItemToCart' method = 'post'>
        <nav>
            <a href="Books.jsp">Books</a>&nbsp;&nbsp;&nbsp;
            <a href="Music.jsp">Music</a>&nbsp;&nbsp;&nbsp;
            <a href="Laptops.jsp">Computers</a>
         </nav>
    <div>
        <label>Shop for Books</label><br/>
        <input type="checkbox" name="orders" value="Java Servlet Programming">Java Servlet Programming[$29.95]<br/>
        <input type="checkbox" name="orders" value="Oracle Database Programming">Oracle Database Programming[$48.95]<br/>
        <input type="checkbox" name="orders" value="System Analysis And Design With UML">System Analysis And Design With UML[$14.95]<br/>
        <input type="checkbox" name="orders" value="Object Oriented Software Engineering">Object Oriented Software Engineering[$35.99]<br/>
        <input type="checkbox" name="orders" value="Java Web Services">Java Web Services[$27.99]<br/>
        <input type="submit" value="Add to Cart"><br/>
    </div>
    </form>
    <form action = 'Cart?operation=viewCartItems' method = 'post'>
         <input type="submit" value = "View Cart"><br/>
    </form>
</body>
</html>