<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="demo.bookmanager.dto.PhoneDto" %>
<%@ page import="demo.bookmanager.dto.PhoneDto" %>
<%
    PhoneDto phoneDto = (PhoneDto) request.getAttribute("phoneDto");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h1>휴대폰 상세 및 수정</h1>
<form action="/phone/update" method="post">
    <input type = "text" name = "phoneId" value="<%= phoneDto.getPhoneId() %>"/><br>
    <input type = "text" name = "name" value="<%= phoneDto.getName() %>"/><br>
    <input type = "text" name = "brand" value="<%= phoneDto.getBrand() %>"/><br>
    <input type = "text" name = "color" value="<%= phoneDto.getColor() %>"/><br>
    <input type = "text" name = "capacity" value="<%= phoneDto.getCapacity() %>"/><br>
    <input type = "text" name = "price" value="<%= phoneDto.getPrice() %>"/><br>
    <input type = "text" name = "stock" value="<%= phoneDto.getStock() %>"/><br>
    <button type="submit">수정</button>
</form>
    <hr>
    <a href="/phone/list"> 목록 </a>
    <a href="/phone/delete?phoneId=<%= phoneDto.getPhoneId() %>"> 삭제 </a>
</body>
</html>