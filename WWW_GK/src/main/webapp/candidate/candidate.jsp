<%@ page import="com.example.www_gk.models.CandidateSkill" %>
<%@ page import="com.example.www_gk.models.Candidate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/24/2024
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Candidate</title>
</head>
<body>

<h1>List Candidate</h1>

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
        <th>Skills</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Candidate> candidate = (List<Candidate>) request.getAttribute("candidates");
        int i = 1;
        for(Candidate can : candidate){
    %>
    <tr>
        <td><%= can.getId() %></td>
        <td><%= can.getFirst_name()%></td>
        <td><%= can.getMiddle_name()%></td>
        <td><%= can.getLast_name()%></td>
        <td><%= can.getPhone()%></td>
        <td><%= can.getEmail()%></td>
        <td><%= can.getAddress()%></td>
        <td><%= can.getDob()%></td>
        <td>
            <%
                List<CandidateSkill> skills = can.getCandidateSkills();
                if (skills != null) {
                    for (CandidateSkill skill : skills) {
                        out.println("Level: " + skill.getSkillLevel().name() + "<br/>");// hien thi ten ky nang va cap do
                    }
                }
                else {
                    out.println("No skill found");
                }
            %>
        </td>
    </tr>
    <%
        }
    %>

    </tbody>
</table>

<form action="page?action=insertCandidate" method="post">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required><br><br>

    <label for="middleName">Middle Name:</label>
    <input type="text" id="middleName" name="middleName" required><br><br>

    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" required><br><br>

    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" required><br><br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" required><br><br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required><br><br>

    <label for="dob">Date of Birth:</label>
    <input type="date" id="dob" name="dob" required><br><br>

    <label for="skill">Skill:</label>
    <select id="skill" name="skill">
        <option value="1">BEGINNER</option>
        <option value="2">INTERMEDIATE</option>
        <option value="3">ADVANCED</option>
        <option value="4">EXPERT</option>
        <option value="5">MASTER</option>
    </select><br><br>

    <button type="submit">Submit</button>

</form>


</body>
</html>
