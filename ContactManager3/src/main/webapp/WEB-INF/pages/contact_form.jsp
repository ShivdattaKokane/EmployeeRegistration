<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New And Edit Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        margin: 0;
        padding: 0;
    }

    .container {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
    }

    form {
        text-align: left;
    }

    .form-group {
        margin-bottom: 15px;
    }

    .form-group label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
    }

    .form-group input {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }

    .form-group input[type="submit"] {
        background-color: #555;
        color: white;
        border: none;
        padding: 10px;
        cursor: pointer;
    }
</style>
</head>
<body>
<div class="container">
    <h1>New / Edit Contact</h1>
    <form:form action="save" method="post" modelAttribute="contact">
        <form:hidden path="id" />
        <div class="form-group">
            <label for="name">Name:</label>
            <form:input path="name" id="name" />
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <form:input path="email" id="email" />
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <form:input path="address" id="address" />
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <form:input path="phone" id="phone" />
        </div>
        <div class="form-group" style="text-align: center;">
            <input type="submit" value="Submit" />
        </div>
    </form:form>
</div>
</body>
</html>
