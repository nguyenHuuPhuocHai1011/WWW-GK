<%@ page import="com.example.www_gk.models.Job" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/24/2024
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Job</title>
</head>
<body>
<h1>Job</h1>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Title</th>
    <th>Description</th>
  </tr>
  </thead>
    <tbody>
    <%
        List<Job> jobs = (List<Job>) request.getAttribute("jobs");
        int i = 1;
        for(Job job : jobs){
    %>
    <tr>
        <td><%= job.getId() %></td>
        <td><%= job.getTitle()%></td>
        <td><%= job.getDescription()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
