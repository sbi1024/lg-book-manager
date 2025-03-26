<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

    <h1>휴대폰 등록</h1>
    <form action="/phone/insert" method="post">
        <input type="text" name="name"/><br>
        <input type="text" name="brand"/><br>
        <input type="text" name="color"/><br>
        <input type="text" name="capacity"/><br>
        <input type="text" name="price"/><br>
        <input type="text" name="stock"/><br>
        <button type="submit">등록</button>
    </form>
    <hr>
    <a href="/phone/list"> 목록 </a>
</body>
</html>