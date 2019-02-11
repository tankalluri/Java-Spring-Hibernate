<%-- 
    Document   : index
    Created on : Feb 10, 2019, 6:08:15 PM
    Author     : tankalluri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP</title>
    </head>
    <body>
        <h2>Core Tags-out,set and if</h2>
        <c:out value="${'My first JSTL tag using c:out'}"></c:out><br>
        
        <c:set var="Income" scope="session" value="${4000*4}"/>  
        <p>Income value: <c:out value="${Income}"/></p> 

        <c:if test="${Income > 8000}">  
        <p>Income value is more than 8000 and the value is <c:out value="${Income}"/><p> 
        </c:if>
            
        <h2>Function tags-contains, length and toUpperCase</h2>
        <c:set var="ctExp" value="Hello Northeastern University"/>  
        <c:if test="${fn:contains(ctExp, 'North')}">  
        <p>Found North in the string Hello Northeastern University<p>  
        </c:if>
        <p>Length of String 'Hello Northeastern University' is ${fn:length(ctExp)}<br></p>  
        <p>The upper case of string ${ctExp} is ${fn:toUpperCase(ctExp)}</p>
        
        <h2>Formatting tags-parseNumber, formateDate, setTimeZone</h2>
         <c:set var="Cost" value="28.12" />  
         <fmt:parseNumber var="j" type="number" value="${Cost}" />  
         <p>Cost of the dress is <c:out value="${j}" /></p>
         <c:set var="Date" value="<%=new java.util.Date()%>" />  
         <p>Formatted Date :  <fmt:formatDate type="date" value="${Date}" /></p>
         <p>Date and Time IST: <fmt:formatDate value="${Date}" type="both" timeStyle="long" dateStyle="long" /></p>  
        <fmt:setTimeZone value="GMT-10" />
        <p>Date and Time in GMT-10 time Zone after time zone change: <fmt:formatDate value="${Date}" type="both" timeStyle="long" dateStyle="long" /></p>
        
        <h2>XML tags-parse, choose, when</h2>
        <c:set var="sport">    
        <sport>  
        <name>Tennis</name>  
        <best>Rafael Nadal</best>  
        </sport> 
        </c:set>  
        <x:parse xml="${sport}" var="output"/>  
        <p>The best tennis player in the world is: <x:out select="$output/sport/best" /></p>
        <x:choose>  
        <x:when select="$output/sport/best = 'Rafael Nadal'">  
        <p>Rafael Nadal is the best Tennis player in the world.</p> 
        </x:when>
        </x:choose>
        
        <h2>SQL tags-setDataSource, update, query</h2>
        <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost/sys" user="root"  password="root"/> 
        <p>Data source has been set successfully.</p>
        <sql:update dataSource="${db}" var="count">  
        INSERT INTO movies VALUES ('Udta Punjab','Shahid Kapoor', 'Alia Bhatt', 'Drama', 2016);  
        </sql:update>  
        <sql:query dataSource="${db}" var="rs">  
        SELECT * from movies;  
        </sql:query>
        
        <table border="2" width="100%">  
        <tr>  
        <th>Title</th>  
        <th>Actor</th>  
        <th>Actress</th>  
        <th>Genre</th>  
        <th>Year of Release</th>  
        </tr>  
        <c:forEach var="table" items="${rs.rows}">  
        <tr>  
        <td> <c:out value="${table.title}" /> </td>  
        <td><c:out value="${table.actor}"/></td>  
        <td><c:out value="${table.actress}"/></td>  
        <td><c:out value="${table.genre}"/></td> 
        <td><c:out value="${table.year}"/></td> 
        </tr>  
        </c:forEach>  
        </table>   
    </body>
</html>