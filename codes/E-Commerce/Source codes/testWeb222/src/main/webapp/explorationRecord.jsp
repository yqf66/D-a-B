<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beautiful Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background: url('./images/R-C.png') no-repeat center center fixed; 
        background-size: cover;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
    }
    form {
        background-color: rgba(255, 255, 255, 0.8);
        padding: 30px;
        border-radius: 5px;
        margin: 10px;
        width: 60%; /* Adjusted width */
        max-width: 600px; /* Maximum width */
    }
    label, input {
        margin-bottom: 15px; /* Increased margin */
    }
    input[type="text"] {
        width: 100%;
        padding: 12px;  /* Increased padding */
        margin: 5px 0 25px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
        border-radius: 4px;
        font-size: 16px; /* Increased font size */
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 14px 25px; /* Adjusted padding */
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px; /* Increased font size */
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    h2 {
        margin-bottom: 20px;
    }
</style>
</head>
<body>
<form method="post" action="./addRecord">
    <h2>Add Record</h2>
    <label for="robotname">Robot Name:</label><br/>
    <input type="text" name="robotname"/><br/>
    <label for="exploration_time">Exploration Time:</label><br/>
    <input type="text" name="exploration_time"/><br/>
    <label for="treasure">Treasure:</label><br/>
    <input type="text" name="treasure"/><br/>
    <label for="picture">Picture:</label><br/>
    <input type="text" name="picture"/><br/>
    <input type="submit" name="add" value="Add Record">
</form>
<form method="post" action="./history">
    <input type="submit" name="return" value="Return">
</form>
</body>
</html>
