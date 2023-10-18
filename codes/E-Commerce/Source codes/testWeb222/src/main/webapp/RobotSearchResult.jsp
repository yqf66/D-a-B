<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "testWeb.vo.Exploration" %>
<%@ page import = "java.util.*" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>DataSearch</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: url('./images/R-C.png') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .data_table {
            width: 90%;
            max-width: 800px;
            border-collapse: collapse;
            background-color: rgba(255, 255, 255, 0.9);
            margin-bottom: 20px;
        }

        .data_table th, .data_table td {
            border: 1px solid black; 
            padding: 8px;
            text-align: left;
        }

        .data_table th {
            background-color: #4CAF50;
            color: white;
        }

        .data_table img {
            max-width: 150px;
            height: auto;
        }

        form {
            margin-bottom: 10px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            border: none;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

    </style>
</head>
<body>
    <% ArrayList<Exploration> ExplorationList=(ArrayList<Exploration>)session.getAttribute("ExplorationList");
       Iterator i=ExplorationList.iterator();
       while(i.hasNext()){
           Exploration e=(Exploration)i.next();
    %>
    <table class="data_table">
        <thead>
            <tr>
                <th>robotname</th>
                <th>timestamp</th>
                <th>statistic_of_treasure</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><%= e.getRobotname() %></td>
                <td><%= e.getTimestamp() %></td>
                <td>
                    <% String imagePath = e.getStatistic_of_treasure(); %>
                    <img src="<%= imagePath %>" alt="Statistic_of_treasure">
                </td>
            </tr>
        </tbody>
    </table>
    <% } %>

    <form method="post" action="./module.jsp">
        <input type="SUBMIT" name="return" value="Return">
    </form>
</body>
</html>
