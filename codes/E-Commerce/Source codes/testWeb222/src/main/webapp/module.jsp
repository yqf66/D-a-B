<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
        }
        form {
            margin: 15px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            font-size: 20px;  /* Increase the font size */
            padding: 20px 30px; /* Make the button larger */
            width: 200px; /* Set a specific width */
            text-align: center; /* Center the text on the button */
            border: none;
            border-radius: 8px;  /* Make the button corners rounded */
            cursor: pointer;
            margin: 10px; /* Increase margin between buttons */
            box-shadow: 0px 5px 15px rgba(0,0,0,0.3);  /* Add a shadow for a 3D effect */
            transition: background-color 0.3s ease, transform 0.3s ease; /* Add transition for a smooth hover effect */
        }
        input[type="submit"]:hover {
            background-color: #45a049;
            transform: scale(1.05);  /* Make the button a bit larger when hovering */
        }
        input[type="submit"]:active {
            transform: scale(0.95);  /* Shrink the button a bit when clicking */
        }
    </style>
</head>
<body>
    <form method="post" action="./search">
        <input type="submit" name="search" value="Search">
    </form>
    <form method="post" action="./history">
        <input type="submit" name="history" value="History">
    </form>
    <form method="post" action="./login.jsp">
        <input type="submit" name="logout" value="Logout">
    </form>
    <form method="post" action="./userdelete">
        <input type="submit" name="log_off" value="Log-off">
    </form>
</body>
</html>
