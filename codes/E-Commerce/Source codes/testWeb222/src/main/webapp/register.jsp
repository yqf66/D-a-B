<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%
    HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-image: url('./images/moroccan-flower.png');
        background-size: cover;
        background-position: center;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        background-color: rgba(255, 255, 255, 0.8);
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        width: 400px;
    }
    label {
        display: inline-block;
        width: 100px;
        margin-bottom: 10px;
    }
    input[type="text"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    .btn-group {
        display: flex;
        justify-content: space-between;
    }
    input[type="button"], input[type="submit"] {
        width: 48%; /* Gives a little spacing between the two buttons */
        background-color: #3498db;
        color: white;
        padding: 14px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s;
    }
    input[type="submit"]:hover, input[type="button"]:hover {
        background-color: #2980b9;
    }
</style>
</head>
<body>

<div class="container">
    <h1>Register</h1>
    <form id="registerForm" name="registerForm" method="post" action="./register">
        <label for="phonenumber">Phone Number:</label>
        <input type="text" id="phonenumber" name="phonenumber"/><br/>

        <label for="email">Email:</label>
        <input type="text" id="email" name="email"/><br/>

        <label for="username">Username:</label>
        <input type="text" id="username" name="username"/><br/>

        <label for="password">Password:</label>
        <input type="text" id="password" name="password"/><br/>

        <label for="robotname">Robot Name:</label>
        <input type="text" id="robotname" name="robotname"></br>

        <div class="btn-group">
            <input type="submit" name="register" value="Register">
            <input type="button" onclick="location.href='./login.jsp'" value="Return">
        </div>
    </form>
</div>

</body>
</html>
