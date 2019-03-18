<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <title>Form Part3</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div>
             <form:form commandName="movieSearch" method="post">
                <div class="form-group">
                    <label for="myear">Movie ID:</label>
                    <form:input path="id" type="text" />
                        <form:errors path="id"/>
                </div>
                <button type="submit" id="submit">Search Movie</button>
             </form:form>
        </div>
    </body>
</html>