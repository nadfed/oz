<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User page</title>
<link rel="stylesheet" type="text/css" href="css.css">
</head>
<body>
	<h1>USER BOOKS ARE:</h1>
	<br>
	<table border="1">
   <tr>
   <th>#</th>
    <th>BOOK</th>
    <th>AUTHOR</th>
   </tr>
		<c:forEach items="${books}" var="i">
				<h3>
					<tr> 
					<td>	<c:out value="${books.indexOf(i)}"/></td>
				<td>	<c:out value="${i.getTitle()}" /></td>
			
					<td><c:out value="${i.getAuthor()}" /> </td>
					</tr>
				</h3>
		</c:forEach>
		</table>
	<br>
</body>
</html>