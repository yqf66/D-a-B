<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
    font-family: Arial, sans-serif;
    background-image: url('./images/zzz.jpg');
    background-size: cover;
    background-position: center;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: flex-end; /* 这将内容移到右侧 */
    align-items: flex-start;   /* 这将内容移到顶部 */
    height: 100vh;
}
.container {
    background-color: rgba(255, 255, 255, 0.8);
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 300px;
    margin: 200px;  /* 为了从顶部和右侧稍微增加一些距离 */
}
        .container form {
            display: flex;
            flex-direction: column;
        }
        input[type="text"], input[type="password"] {
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            padding: 10px;
            background-color: #007BFF;
            border: none;
            border-radius: 3px;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <form method="post" action="./login">
            <label>Username:</label>
            <input type="text" name="username" placeholder="Enter username" />
            <label>Password:</label>
            <input type="password" name="password" placeholder="Enter password" />
            <input type="submit" name="submit" value="Submit" />
        </form>
        <form method="post" action="./register.jsp">
            <input type="submit" name="register" value="Register" />
        </form>
        <form method="post" action="./Find_password.jsp">
            <input type="submit" name="find_password" value="Find password" />
        </form>
    </div>
</body>
</html>

