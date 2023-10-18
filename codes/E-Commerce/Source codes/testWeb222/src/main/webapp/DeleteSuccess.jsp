<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Success</title>
<style>
  body {
    font-family: 'Arial', sans-serif;
    background: linear-gradient(120deg, #a1ffce, #faffd1); /* Gradient with a more positive feel */
    color: #333;
    padding: 0;
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }

  .card {
    background: #fff;
    padding: 40px;
    border-radius: 10px;
    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
    text-align: center;
    width: 350px;
  }

  .success-message {
    color: #5cb85c; /* Bootstrap success color */
    font-size: 18px;
    margin-bottom: 20px;
  }

  .btn {
    display: block;
    padding: 10px 20px;
    border: none;
    background-color: #007BFF;
    color: #fff;
    cursor: pointer;
    transition: background-color 0.3s, transform 0.3s;
    border-radius: 5px;
    margin: 10px 0;
    width: 100%;
    text-align: center;
  }

  .btn:hover {
    background-color: #0056b3;
    transform: translateY(-2px);
    text-decoration: none; 
  }

  .btn:active {
    transform: translateY(0);
  }
</style>
</head>
<body>
<div class="card">
    <div class="success-message">Delete Success</div>
    <form method="post" action="./history">
        <input type="submit" class="btn" name="return" value="Return">
    </form>
</div>
</body>
</html>
