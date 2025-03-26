<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="demo.bookmanager.dto.PhoneDto" %>
<%@ page import="demo.bookmanager.dto.PhoneDto" %>
<%
    List<PhoneDto> phoneList = (List<PhoneDto>) request.getAttribute("phoneList");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>휴대폰 목록</h1>
<table>
    <thead>
    <tr>
        <th>phoneId</th>
        <th>name</th>
        <th>brand</th>
        <th>color</th>
        <th>capacity</th>
        <th>price</th>
        <th>stock</th>
    </tr>
    </thead>
    <tbody>
    <%
        for( PhoneDto phoneDto : phoneList ){
    %>
    <tr>
        <td><a href="/phone/detail?phoneId=<%= phoneDto.getPhoneId() %>"><%= phoneDto.getPhoneId() %></a></td>
        <td><%= phoneDto.getName() %></td>
        <td><%= phoneDto.getBrand() %></td>
        <td><%= phoneDto.getColor() %></td>
        <td><%= phoneDto.getCapacity() %></td>
        <td><%= phoneDto.getPrice() %></td>
        <td><%= phoneDto.getStock() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<hr>
<a href="/insertForm.jsp"> 등록 </a>
<a href="/"> 홈 </a>
</body>
</html>

