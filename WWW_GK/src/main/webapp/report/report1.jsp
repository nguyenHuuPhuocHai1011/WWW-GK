<%@ page import="com.example.www_gk.models.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.www_gk.models.CandidateSkill" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/24/2024
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REPORT 1</title>
</head>
<body>

<h1>REPORT 1</h1>

<br>

<form method="post">
    <label for="skillLevel">Skill Level</label>
    <select name="skillLevel" id="skillLevel">
        <option name = "BEGINNER" value="0">BEGINNER</option>
        <option name = "INTERMEDIATE" value="1">INTERMEDIATE</option>
        <option name = "ADVANCED" value="2">ADVANCED</option>
        <option name = "EXPERT" value="3">EXPERT</option>
        <option name = "MASTER" value="4">MASTER</option>
    </select>
    <button type="submit">View</button>
</form>

<div>
    <h1>List Candidate By Level</h1>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Middle Name</th>
            <th>Last Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Dob</th>
            <th>Skill Level</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Candidate> candidates = (List<Candidate>) request.getAttribute("candidates");
            if(candidates != null) {
                for (Candidate candidate : candidates) {
        %>
        <tr>
            <td><%= candidate.getId() %></td>
            <td><%= candidate.getFirst_name() %></td>
            <td><%= candidate.getMiddle_name() %></td>
            <td><%= candidate.getLast_name() %></td>
            <td><%= candidate.getPhone() %></td>
            <td><%= candidate.getEmail() %></td>
            <td><%= candidate.getAddress() %></td>
            <td><%= candidate.getDob() %></td>
            <td>
                <%
                    List<CandidateSkill> candidateSkills = candidate.getCandidateSkills();
                    for (CandidateSkill candidateSkill : candidateSkills) {
                        out.println("skillLevel: " + candidateSkill.getSkillLevel().getValue() + "<br/>");
                    }
                %>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>

</body>
</html>
