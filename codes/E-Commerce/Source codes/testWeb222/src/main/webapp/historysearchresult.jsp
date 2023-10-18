<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "testWeb.vo.HistoryRecord" %>
<%@ page import = "java.util.*" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>HistorySearchResult</title>
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

        .history-table {
            width: 90%;
            max-width: 800px;
            border-collapse: collapse;
            background-color: rgba(255, 255, 255, 0.9);
            margin-bottom: 20px;
        }

        .history-table th, .history-table td {
            border: 1px solid black; 
            padding: 8px;
            text-align: left;
        }

        .history-table th {
            background-color: #4CAF50;
            color: white;
        }

        .history-table img {
            max-width: 100px;
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
    <% ArrayList<HistoryRecord> historyList = (ArrayList<HistoryRecord>)session.getAttribute("historylist");
       Iterator i = historyList.iterator();
       while(i.hasNext()){
           HistoryRecord record = (HistoryRecord)i.next();
    %>
    <table class="history-table">
        <thead>
            <tr>
                <th>historyRecordID</th>
                <th>robotname</th>
                <th>exploration_time</th>
                <th>treasure</th>
                <th>picture</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><%= record.getHistoryRecordID() %></td>
                <td><%= record.getRobotname() %></td>
                <td><%= record.getExploration_time() %></td>
                <td><%= record.getTreasure() %></td>
                <td>
                    <% String imagePath = record.getPicture(); %>
                    <img src="<%= imagePath %>" alt="treasure">
                </td>
            </tr>
        </tbody>
    </table>
    <% } %>

    <form method="post" action="./historydeleteresult.jsp">
        <input type="SUBMIT" name="delete" value="Delete">
    </form>
    <form method="post" action="./explorationRecord.jsp">
        <input type="SUBMIT" name="add" value="Add">
    </form>
    <form method="post" action="./HistoryChange.jsp">
        <input type="SUBMIT" name="change" value="Change">
    </form>
    <form method="post" action="./module.jsp">
        <input type="SUBMIT" name="return" value="Return">
    </form>
</body>
</html>
