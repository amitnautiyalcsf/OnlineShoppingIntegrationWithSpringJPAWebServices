<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table{
border-collapse: collapse;

}


</style>
</head>
<body>
<h1>Online Shopping Home page </h1>

<c:choose>
<c:when test="${ilist.size()>0}">
<h2>Available Items</h2>


<table border="1">
<tr>
<td>ID</td>
<td>Name</td>
<td>Price</td>
<td>Category</td>
<td>Quantity</td>
</tr>
<c:forEach var="itm" items="${ilist}">
<tr>
<td>${itm.id}</td>
<td>${itm.name}</td>
<td>${itm.price}</td>
<td>${itm.category}</td>
<td>${itm.quantity}</td>
</tr>
</c:forEach>

</table>

<br>


<form:form action="placeOrder.obj" modelAttribute="sitem">
Enter item ID: <form:input path="id" type="text" value=""/><br>
<input type="submit" value="Place Order"/>
</form:form>
</c:when>
<c:otherwise>
<h3>No Items Were Found</h3>

</c:otherwise>
</c:choose>
</body>
</html>