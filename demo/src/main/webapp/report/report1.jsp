<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.models.Candidate" %>
<%@ page import="com.example.demo.models.CandidateSkill" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/25/2024
  Time: 10:09 AM
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
  <label for="skillLevel"> Levels
    <select id="skillLevel" name="skillLevel">
      <option name = "BEGINNER" value="0">BEGINNER</option>
      <option name = "INTERMEDIATE" value="1">INTERMEDIATE</option>
      <option name = "ADVANCED" value="2">ADVANCED</option>
      <option name = "EXPERT" value="3">EXPERT</option>
      <option name = "MASTER" value="4">MASTER</option>
    </select>
  </label>
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
      if(candidates != null){
        for (Candidate can : candidates) {
    %>
    <tr>
      <td><%= can.getId() %></td>
      <td><%= can.getFirst_name() %></td>
      <td><%= can.getMiddle_name() %></td>
      <td><%= can.getLast_name() %></td>
      <td><%= can.getPhone() %></td>
      <td><%= can.getEmail() %></td>
      <td><%= can.getAddress() %></td>
      <td><%= can.getDob() %></td>
      <td>
        <%
          List<CandidateSkill> skills = can.getCandidateSkills();
            for (CandidateSkill skill : skills) {
                out.println("Level: " + skill.getSkillLevel().getValue() + "<br/>"); // Hiển thị tên kỹ năng và cấp độ
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
