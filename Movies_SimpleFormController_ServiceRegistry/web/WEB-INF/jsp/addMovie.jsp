<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div>   
            <form:form commandName="movie" method="post">
                <div >
                    <label>Movie Title:</label>
                    <form:input path="title" type="text"  />
                    <form:errors path="title"/>
                </div>
                <br>
                <div >
                    <label for="mactor">Lead Actor:</label>
                    <form:input path="actor" type="text"  />
                    <form:errors path="actor"/>
                </div>
                <br>
                <div >
                    <label>Lead Actress:</label>
                    <form:input path="actress" type="text"  />
                    <form:errors path="actress"/>
                </div>
                <br>
                <div >
                    <label>Genre:</label>
                    <form:input path="genre" type="text"  />
                    <form:errors path="genre"/>
                </div>
                <br>
                <div >
                    <label>Year:</label>
                    <form:input path="year" type="text"  />
                    <form:errors path="year"/>
                </div>
                <br>
                <input type="hidden" value="add" name="option" />
                <button type="submit" id="submit">Add Movie</button>
            </form:form>
        </div>
    </body>
</html>