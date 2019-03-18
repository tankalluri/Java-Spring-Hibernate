<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>     
 <title>Movie Added</title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
    <body>
        <c:set var="Message" value="${requestScope.message}"/>
        <h1>${message}</h1>
    </body>
</html>
