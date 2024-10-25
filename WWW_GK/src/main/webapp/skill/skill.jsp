<%@ page import="com.example.www_gk.models.Skill" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/24/2024
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Skill</title>
</head>
<body>

<h1>Skill</h1>

<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Field</th>
    <th>Skill Name</th>
    <th>Description</th>
  </tr>
  </thead>
    <tbody>
    <%
        List<Skill> skills = (List<Skill>) request.getAttribute("skills");
        int i = 1;
        for(Skill skill : skills){
    %>
    <tr>
        <td><%= skill.getId() %></td>
        <td><%= skill.getField()%></td>
        <td><%= skill.getSkillName()%></td>
        <td><%= skill.getDescription()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
