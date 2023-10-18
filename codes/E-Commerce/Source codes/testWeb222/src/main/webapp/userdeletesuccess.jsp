<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4; /* Light grey background */
            color: #333; /* Dark text color */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* full viewport height */
            background-image: url('./images/R-C.png'); /* Replace with the path to your background image */
            background-size: cover;
            background-repeat: no-repeat;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.8); /* Slight white background with opacity */
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Slight shadow for depth */
            width: 300px;
            text-align: center;
        }

        .btn {
            background-color: #007BFF; /* Blue color */
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Success</h2>
        <form method="post" action="./login.jsp">
            <input class="btn" type="submit" name="return" value="Return">
        </form>
    </div>
</body>
</html>
