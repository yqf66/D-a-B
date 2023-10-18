<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            /* Added a generic background gradient with green tones for success */
            background: linear-gradient(to bottom right, #66BB6A, #388E3C);
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        .content {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            text-align: center;
        }
        input[type="SUBMIT"] {
            background-color: #4CAF50;
            color: white;
            padding: 15px 30px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="SUBMIT"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="content">
    <h1>delete_success</h1>
    <form method="post" action="./login.jsp">
        <input type="SUBMIT" name="return" value="Return">
    </form>
</div>
</body>
</html>
