<%@ page import="com.example.thuoc_demo.models.LoaiThuoc" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.thuoc_demo.models.Thuoc" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/26/2024
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Thuoc</title>
</head>
<body>
<h1>Insert Thuoc</h1>

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
<br>

<form action="page?action=insertThuoc" method="post">
    <table>
        <tr>
            <td>Ma Thuoc</td>
            <td><input type="text" name="maThuoc"></td>
        </tr>
        <tr>
            <td>Ten Thuoc</td>
            <td><input type="text" name="tenThuoc"></td>
        </tr>
        <tr>
            <td>Gia</td>
            <td><input type="text" name="gia"></td>
        </tr>
        <tr>
            <td>Nam SX</td>
            <td><input type="text" name="namSX"></td>
        </tr>
        <tr>
            <td>Ma Loai</td>
            <%
              List<LoaiThuoc> loaiThuocs = (List<LoaiThuoc>) request.getAttribute("loaiThuocs");
              for (LoaiThuoc lt : loaiThuocs){
            %>
            <option value="<%=lt.getMaLoai()%>"><%=lt.getTenLoai()%></option>
          <% } %>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Insert"></td>
        </tr>
    </table>
</form>
</body>
</html>
