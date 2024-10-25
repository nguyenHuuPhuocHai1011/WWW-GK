<%@ page import="com.example.demo1.models.CandidateSkill" %>
<%@ page import="com.example.demo1.models.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/25/2024
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Candidate Detail</title>
</head>
<body>
    <h1>Candidate Detail</h1>
    <%
      Candidate candidate = (Candidate) request.getAttribute("candidates");
      StringBuilder listSkillLevel = new StringBuilder();
      for(CandidateSkill candidateSkill:
              candidate.getCandidateSkills()){
        listSkillLevel.append(candidateSkill);
      }
      System.out.println(listSkillLevel);
    %>
    <table>
        <tr>
            <td>ID</td>
            <td><%=candidate.getId()%></td>
        </tr>
        <tr>
            <td>LastName</td>
            <td><%=candidate.getLast_name()%></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><%=candidate.getPhone()%></td>
        </tr>
        <tr>
            <td>List CandidateSkill</td>
            <td><%=candidate.getCandidateSkills()%></td>
        </tr>
    </table>
</body>
</html>
