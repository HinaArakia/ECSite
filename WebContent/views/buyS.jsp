<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>


<!-- CSS -->
<link href="<c:url value="/css/cart.css"/>" rel="stylesheet">
  <title>ショッピングサイト 購入結果</title>
</head>
<body>
	<jsp:include page="/views/header.jsp" />
 <div class="fontA">購入完了</div>
<ul id="wrap">
    <li class="box1 a"><p>確認</p></li>
    <li class="box1 b"><p>購入完了</p></li>

</ul>
  <div class="fontB">購入しました。</p>
  <form action="/ECSite/ItemServlet" method="get">
      <input type="submit" value="TOPに戻る" class="button">
  </form>
</body>
</html>