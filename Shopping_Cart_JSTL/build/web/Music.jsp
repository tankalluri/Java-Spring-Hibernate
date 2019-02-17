<%-- 
    Document   : Music
    Created on : Feb 11, 2019, 5:42:31 PM
    Author     : tankalluri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <label>Shop for CDs</label><br/>
        <input type="checkbox" name=orders" value="I'm going to tell you a secret by Madonna">I'm going to tell you a secret by Madonna[$26.99]<br/>
        <input type="checkbox" name="orders" value="Baby one more time by Britney Spears">Baby one more time by Britney Spears[$10.95]<br/>
        <input type="checkbox" name="orders" value="Justified by Justin Timberlake">Justified by Justin Timberlake[$9.97]<br/>
        <input type="checkbox" name="orders" value="Loose by Nelly Furtado">Loose by Nelly Furtado[$13.98]<br/>
        <input type="checkbox" name="orders" value="Gold Digger by Kanye West">Gold Digger by Kanye West[$27.99]
        <br/>
        <input type="submit" value="Add to Cart"><br/>
    </div>
    </form>
    <form action = 'Cart?operation=viewCartItems' method = 'post'>
       <input type="submit" value = "View Cart"><br/>
    </form>
</body>
</html>
