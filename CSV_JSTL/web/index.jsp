<%-- 
    Document   : index
    Created on : Feb 10, 2019, 1:47:10 AM
    Author     : tankalluri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSV Extraction</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <header><h1>CSV DATA EXTRACTION</h1></header>
           <main>
            <form style="margin-left: 550px; margin-top: 30px;" method="post" action="CSVExtraction.xls">
                <div style="font-size: 20px; color: blue; font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif">
                <label>Please enter the file name</label><br><br>
                <input name="fileName"/><br>
                <input type="submit" value="Submit" style="border-radius: 20px; background-color: steelblue; color: white; font-size: 20px; margin-left: 160px">
                </div>
            </form>
            </main>
    </body>
</html>
