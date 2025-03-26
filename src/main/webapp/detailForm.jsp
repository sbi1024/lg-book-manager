<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="demo.bookmanager.dto.BookDto" %>
<%
    BookDto bookDto = (BookDto) request.getAttribute("bookDto");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h1>도서 상세 및 수정</h1>
<form action="/books/update" method="post">
    <input type = "text" name = "bookId" value="<%= bookDto.getBookId() %>"/><br>
    <input type = "text" name = "bookName" value="<%= bookDto.getBookName() %>"/><br>
    <input type = "text" name = "publisher" value="<%= bookDto.getPublisher() %>"/><br>
    <input type = "text" name = "price" value="<%= bookDto.getPrice() %>"/><br>
    <button type="submit">수정</button>
</form>
    <hr>
    <a href="/books/list"> 목록 </a>
    <a href="/books/delete?bookId=<%= bookDto.getBookId() %>"> 삭제 </a>
</body>
</html>