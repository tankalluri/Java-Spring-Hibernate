 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
                  location.replace("http://localhost:8080/HW_4_Part_5/SearchMovie.jsp");
              }else{
                  location.replace("http://localhost:8080/HW_4_Part_5/AddNewMovie.jsp");
              }
            }
        </script>
    </body>
</html>
