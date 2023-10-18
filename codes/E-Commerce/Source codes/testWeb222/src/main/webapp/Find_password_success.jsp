<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Recovery Success</title>
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
        text-align: center;
    }
    h1 {
        color: #2ecc71;
        font-size: 2rem;
    }
    p {
        font-size: 1rem;
        margin-bottom: 20px;
    }
    input[type="submit"] {
        background-color: #3498db;
        color: white;
        padding: 14px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #2980b9;
    }
</style>
</head>
<body>

<div class="container">
    <h1>Successfully Recovered</h1>
    <p>Your password has been successfully recovered.</p>
    <form method="post" action="./login.jsp">
        <input type="submit" name="move_on" value="Move On">
    </form>
</div>

</body>
</html>
