<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "testWeb.vo.HistoryRecord" %>
<%@ page import = "java.util.*" %>  

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>HistoryDeleteResult</title>
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
            flex-direction: column;
        }

        .history-table {
            width: 100%;
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

        form {
            background-color: rgba(255, 255, 255, 0.7);
            padding: 15px;
            border-radius: 8px;
            width: 100%;
            max-width: 800px;
        }

        input[type="text"], input[type="submit"] {
            padding: 10px;
            border-radius: 4px;
            margin: 5px 0;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            border: none;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .message {
            color: red;
            margin-top: 10px;
        }

        button {
            background-color: #4CAF50;
            border: none;
            padding: 10px 15px;
            color: white;
            cursor: pointer;
            border-radius: 4px;
            margin-top: 10px;
        }

        button:hover {
            background-color: #45a049;
        }

        button a {
            text-decoration: none;
            color: white;
        }

        /* Additional Styles */
        img {
            max-width: 100px;
            max-height: 100px;
            display: block;
            margin: 0 auto;
        }
        label {
            font-weight: bold;
            margin-top: 10px;
            display: block;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0 15px 0;
            display: inline-block;
            border: 1px solid #aaa; 
            background: #f1f1f1;
            border-radius: 4px;
        }
        .history-table tbody tr td {
            vertical-align: middle; 
        }
    </style>
</head>
<body>
    <% ArrayList<HistoryRecord> deletelist = (ArrayList<HistoryRecord>)session.getAttribute("historylist");
       Iterator i = deletelist.iterator();
       while(i.hasNext()){
           HistoryRecord record = (HistoryRecord)i.next();
    %>
    <table class="history-table">
        <thead>
            <tr>
                <th>Select</th>
                <th>historyRecordID</th>
                <th>robotname</th>
                <th>exploration_time</th>
                <th>treasure</th>
                <th>picture</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><input type="checkbox" name="selectedRecords" value="<%= record.getHistoryRecordID() %>"></td>
                <td><%= record.getHistoryRecordID() %></td>
                <td><%= record.getRobotname() %></td>
                <td><%= record.getExploration_time() %></td>
                <td><%= record.getTreasure() %></td>
                <td><% String imagePath = record.getPicture(); %>
                    <img src="<%= imagePath %>" alt="treasure"></td>
            </tr>
        </tbody>
    </table>
    <% } %>

    <form method="post" action="./deleteRecord">
        <label>Delete Record</label><br/>
        <input type="text" name="historyRecordID" placeholder="ID of Records to Delete"/><br/>
        <input type="submit" name="delete" value="Delete Record"/>
        <!-- Messages -->
        <% if (request.getAttribute("deletemessage") != null) { %>
          <div class="message">
              <%= request.getAttribute("deletemessage") %>
          </div>
        <% } else if (request.getAttribute("nodeletemessage") != null) { %>
          <div class="message">
              <%= request.getAttribute("nodeletemessage") %>
          </div>
        <% } %>
    </form>

    <form method="post" action="./history">
        <input type="SUBMIT" name="return" value="Return">
    </form>
</body>
</html>
