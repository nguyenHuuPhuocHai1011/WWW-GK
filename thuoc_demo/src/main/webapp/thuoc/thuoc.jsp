<%@ page import="java.util.List" %>
<%@ page import="com.example.thuoc_demo.models.Thuoc" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/26/2024
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Thuoc</title>
</head>
<body>
<h1>List Thuoc</h1>
<table>
  <thead>
    <tr>
      <th>Ma Thuoc</th>
      <th>Ten Thuoc</th>
      <th>Gia</th>
      <th>Nam SX</th>
      <th>Ma Loai</th>
    </tr>
  </thead>
  <tbody>
  <%
    List<Thuoc> thuocs = (List<Thuoc>) request.getAttribute("thuocs");
    int i = 1;
    for(Thuoc t : thuocs){
  %>
  <tr>
    <td><%=t.getMaThuoc()%></td>
    <td><%=t.getTenThuoc()%></td>
    <td><%=t.getGia()%></td>
    <td><%=t.getNamSX()%></td>
    <td><%=t.getLoaiThuoc().getMaLoai()%></td>
  </tr>
  <%
    }
  %>
  </tbody>
</table>
</body>
</html>
