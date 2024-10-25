<%@ page import="com.example.demo.models.Skill" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/25/2024
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Skill</title>
</head>
<body>
<h1>List Skill</h1>
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
        for (Skill skill : skills) {
    %>
    <tr>
        <td><%= skill.getId() %></td>
        <td><%= skill.getField() %></td>
        <td><%= skill.getSkillName() %></td>
        <td><%= skill.getDescription() %></td>
    </tr>
    <%
        }
    %>
    </tbody>

</table>
</body>
</html>
