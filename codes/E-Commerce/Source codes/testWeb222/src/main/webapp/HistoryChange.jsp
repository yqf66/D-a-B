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
    font-family: 'Arial', sans-serif;
    background-image: url('./images/R-C.png');
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
    color: #333;
    padding: 20px;
  }
  
  .history-table {
    border-collapse: collapse;
    width: 100%;
    background-color: rgba(255, 255, 255, 0.8);
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    margin-bottom: 20px;
  }

  .history-table th, .history-table td {
    border: 1px solid #ddd;
    padding: 15px;
    text-align: left;
  }
  
  .history-table thead {
    background-color: #f2f2f2;
  }
  
  .history-table tr:hover {
    background-color: #f5f5f5;
  }

  input[type="submit"] {
    padding: 10px 20px;
    border: none;
    background-color: #333;
    color: #fff;
    cursor: pointer;
    transition: background-color 0.3s;
    border-radius: 5px;
    margin-top: 20px;
  }

  input[type="submit"]:hover {
    background-color: #555;
  }

</style>
<script>
function handleCheckboxClick(checkbox) {
  var checkboxes = document.getElementsByName("selectedRecords");
  
  if (checkbox.checked) {
    for (var i = 0; i < checkboxes.length; i++) {
      if (checkboxes[i] !== checkbox) {
        checkboxes[i].checked = false;
      }
    }
  }
}
</script>
</head>
<body>
<form method="post" action="changeFor">
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
      <% ArrayList<HistoryRecord> deletelist = (ArrayList<HistoryRecord>)session.getAttribute("historylist");
         Iterator i = deletelist.iterator();
         while(i.hasNext()){
            HistoryRecord record = (HistoryRecord)i.next();
      %>
         <tr>
            <td><input type="checkbox" name="selectedRecords" value="<%= record.getHistoryRecordID() %>" onclick="handleCheckboxClick(this)" /></td>
            <td><%= record.getHistoryRecordID() %></td>
            <td><%= record.getRobotname() %></td>
            <td><%= record.getExploration_time() %></td>
            <td><%= record.getTreasure() %></td>
            <td><%= record.getPicture() %></td>
         </tr>
      <% } %>
      </tbody>
   </table>
   <input type="SUBMIT" name="change" value="Change">
</form>
<form method="post" action="./historysearchresult.jsp">
   <input type="SUBMIT" name="return" value="Return">
</form>
</body>
</html>

