<%@ page import="com.example.demo2.models.Skill" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/25/2024
  Time: 10:07 PM
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
            int i = 0;
            for(Skill
                    s: skills){
       %>
       <tr>
           <td><%=s.getId()%></td>
           <td><%=s.getField()%></td>
           <td><%=s.getSkillName()%></td>
           <td><%=s.getDescription()%></td>

       </tr>

       <%
            }
       %>
    </tbody>
</table>
</body>
</html>
