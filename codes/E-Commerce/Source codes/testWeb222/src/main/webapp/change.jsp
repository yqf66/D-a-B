<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Record</title>
<style>
   body {
    font-family: 'Arial', sans-serif;
    background-image: url('./images/R-C.png');
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center;
    color: #fff;
    padding: 50px;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-attachment: fixed;
  }

  form {
    background-color: rgba(0, 0, 0, 0.7);
    padding: 30px 40px;
    border-radius: 10px;
    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
    width: 360px;
  }

  label {
    display: block;
    font-size: 18px;
    margin-bottom: 5px;
    margin-top: 20px;
  }

  input[type="text"] {
    width: 90%;
    padding: 12px 15px;
    margin-bottom: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.8);
    font-size: 16px;
  }

  input[type="submit"] {
    padding: 12px 20px;
    border: none;
    background-color: #007BFF;
    color: #fff;
    cursor: pointer;
    transition: background-color 0.3s;
    border-radius: 5px;
    display: block;
    width: 100%;
    font-size: 16px;
  }

  input[type="submit"]:hover {
    background-color: #0056b3;
  }

</style>
</head>
<body>
<form method="post" action="changeRecord">
    <label>
        Robotname: 
        <input type="text" name="robotname" value='<%=session.getAttribute("robotname") %>'/>
    </label>
    <label>
        Exploration_time: 
        <input type="text" name="exploration_time" value='<%=session.getAttribute("exploration_time") %>'/>
    </label>
    <label>
        Treasure: 
        <input type="text" name="treasure" value='<%=session.getAttribute("treasure") %>'/>
    </label>
    <label>
        Picture: 
        <input type="text" name="picture" value='<%=session.getAttribute("picture") %>'/>
    </label>
    <input type="hidden" name="historyRecordID" value='<%=session.getAttribute("historyRecordID") %>'/>
    <div style="margin-top: 25px;">
        <input type="SUBMIT" name="change" value="Change">
    </div>
</form>
</body>
</html>

