<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Management (curd Operation )</title>
<style>
	/* styles.css */
body {
    font-family: Arial, sans-serif;
    background-color: #f7f7f7;
    margin: 0;
    padding: 0;
}

.container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
}

header {
    background-color: #333;
    color: white;
    text-align: center;
    padding: 10px 0;
}

.navbar {
    background-color: #555;
    padding: 10px;
    text-align: right;
}

.navbar a {
    color: white;
    text-decoration: none;
    margin-left: 10px;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

table, th, td {
    border: 1px solid #ccc;
}

th, td {
    padding: 10px;
    text-align: left;
}

th {
    background-color: #f2f2f2;
}

.form-container {
    margin-top: 20px;
    text-align: center;
}

.form-container label, .form-container input, .form-container button {
    margin: 5px;
}

.form-container button {
    background-color: #555;
    color: white;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
}
	
</style>
</head>
<body>
<div align ="center">
 <h1>Contact List</h1>
  
 <form action="${pageContext.request.contextPath}/" method="get">
    <label for="searchName">Search by Name:</label>
    <input type="text" id="searchName" name="searchName">
    <button type="submit">Search</button>
</form>
 
 <table border = "1" cellpadding="5">
 
 <tr>
 <th>No</th>
 <th>Name</th>
 <th>Email</th>
 <th>Address</th>
 <th>Phone</th> 
 <th>Action</th>
 </tr>
  <c:forEach items="${listContact}" var="contact" varStatus="status">
  <tr>
  <td>${status.index+1}</td>
  <td>${contact.name}</td>
  <td>${contact.email}</td>
  <td>${contact.address}</td>
  <td>${contact.phone}</td>
  <td>
  <a href ="edit?id=${contact.id}">Edit</a>
  &nbsp;&nbsp;
  <a href ="delete?id=${contact.id}">Delete</a>
  </td>
  </tr>
  </c:forEach>
 </table>
 <h3><a href="new">New Contact</a></h3>
 
 
 </div>
 
</body>
</html>