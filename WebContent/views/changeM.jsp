<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>書籍一覧</title>
</head>
<body>

  <div id="main"></div>
  <p>書籍一覧画面</p>
  <span class="mgr">書籍名：<input type="text" name="BookName"><input id="sbtn5" type="submit" value="検索"></span>
 ジャンル名：<select name="genre">
 <option value="1">文学</option>
 <option value="2">経済</option>
 <option value="3">技術</option>
 <input type="submit" value="検索"><br/>
  </select><br/>
  <table border="1">
  <tr>
      <th>書籍ID</th>
      <th>書籍名</th>
      <th>著者</th>
      <th>発行日</th>
      <th>在庫</th>
      <th>ジャンル名</th>
  </tr>
  <c:forEach var="book" items="${book}">
  <tr>
    <th>${book.bookId }</th>
    <th>${book.bookName}</th>
    <th>${book.author}</th>
    <th>${book.publicatoindate }</th>
    <th>${book.stock}</th>
    <th>${book.genreId}</th>
 </tr>
 </c:forEach>
</table>
</body>
</html>