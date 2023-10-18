<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Recovery</title>
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
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        width: 330px;
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
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type="submit"]:hover, input[type="button"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>

<div class="container">
    <h1>Find Your Password</h1>
    <form method="post" action="./Find_password">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"/><br/>
        
        <label for="newpassword">New Password:</label>
        <input type="text" id="newpassword" name="newpassword"/><br/>
        
        <div class="btn-group">
            <input type="submit" name="submit" value="Submit">
            <input type="button" onclick="location.href='./login.jsp'" value="Return">
        </div>
    </form>
</div>

</body>
</html>

