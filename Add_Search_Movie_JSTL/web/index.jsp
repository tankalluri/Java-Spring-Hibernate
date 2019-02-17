<%-- 
    Document   : index
    Created on : Feb 9, 2019, 11:33:41 PM
    Author     : tankalluri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Page</title>
    </head>
    <body>
        <h1>Please make your selection below</h1>
        <div class="dropdown">
            <div class="dropdown-content">
                <select name="movie" id="movieId">
                    <option value='Browse Movies'>Browse Movies</option>
                    <option value='Add New Movie to database'>Add New Movie to database</option>
                </select>
                
            <button onclick="myFunction()">Send</button>
            </div>
        </div><br />
        
        <script>
            function myFunction() {
              
              var index = document.getElementById("movieId").selectedIndex;
              if(index == 0){
                  location.replace("http://localhost:8080/HW3_Part7/SearchMovie.jsp");
              }else{
                  location.replace("http://localhost:8080/HW3_Part7/AddNewMovie.jsp");
              }
            }
        </script>
    </body>
</html>

