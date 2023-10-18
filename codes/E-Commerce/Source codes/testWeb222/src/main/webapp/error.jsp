<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error - Wrong Credentials</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        text-align: center;
    }
    h1 {
        color: #e74c3c;
        font-size: 2rem;
    }
    p {
        font-size: 1rem;
    }
    .return-btn {
        background-color: #3498db;
        color: #ffffff;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 1rem;
        transition: background-color 0.3s;
        margin-top: 20px; 
    }

    .return-btn:hover {
        background-color: #2980b9;
    }
</style>
</head>
<body>

<div class="container">
    <h1>Error</h1>
    <p>You have entered wrong username or password.</p>


    <form method="post" action="./login.jsp">
        <input type="submit" class="return-btn" name="return" value="Return">
    </form>
</div>

</body>
</html>
