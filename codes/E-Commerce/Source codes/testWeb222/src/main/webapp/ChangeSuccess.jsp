<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
<style>
  body {
    font-family: 'Arial', sans-serif;
    background: linear-gradient(120deg, #f6d365, #fda085);
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

  h2 {
    font-size: 24px;
    margin-bottom: 20px;
  }

  button, input[type="submit"] {
    padding: 10px 20px;
    border: none;
    background-color: #007BFF;
    color: #fff;
    cursor: pointer;
    transition: background-color 0.3s, transform 0.3s;
    border-radius: 5px;
    margin: 10px 0;
    width: 100%;
  }

  button:hover, input[type="submit"]:hover {
    background-color: #0056b3;
    transform: translateY(-2px);
  }

  button:active, input[type="submit"]:active {
    transform: translateY(0);
  }

  a {
    color: #fff;
    text-decoration: none;
  }

  button a:hover {
    text-decoration: underline;
  }
</style>
</head>
<body>
<div class="card">
    <h2>Success</h2>
    <form method="post" action="./history">
	    <input type="SUBMIT" name="return" value="Return">
    </form>	
</div>
</body>
</html>
