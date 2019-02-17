<%-- 
    Document   : Laptops
    Created on : Feb 11, 2019, 5:41:45 PM
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
        <label>Shop for Laptops</label><br/>
        <input type="checkbox" name="orders" value="Apple MacBook Pro with 13 3 inch Display">Apple MacBook Pro with 13 3" Display[$1299.99]<br/>
        <input type="checkbox" name="orders" value="Asus Laptop with Centrino 2 Black">Asus Laptop with Centrino 2 Black[$949.9]<br/>
        <input type="checkbox" name="orders" value="HP Pavilion Laptop">HP Pavilion Laptop[$1199.95]<br/>
        <input type="checkbox" name="orders" value="Toshiba Satellite Laptop with Centrino-2 Copper">Toshiba Satellite Laptop with Centrino-2 Copper[$899.99]<br/>
        <input type="checkbox" name="orders" value="Sony VAIO Laptop with Core 2 Duo Cosmopolitan Pink">Sony VAIO Laptop with Core 2 Duo Cosmopolitan Pink[$779.99]<br/><br/>
        <input type="submit" value="Add to Cart"><br/>
    </div>
    </form>
    <form action = 'Cart?operation=viewCartItems' method = 'post'>
         <input type="submit" value = "View Cart"><br/>
    </form>
</body>
</html>