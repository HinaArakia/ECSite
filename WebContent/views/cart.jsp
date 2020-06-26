
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:useBean id="loginBean" class="jp.co.aforce.beans.LoginBean"
	scope="request" />


<jsp:useBean id="cartInBean" class="jp.co.aforce.beans.CartInBean"
	scope="session" />

<!doctype html>
<html>
<head>
<!-- CSS -->
<link href="<c:url value="/css/EC.css"/>" rel="stylesheet">

<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>カートに入れました</title>
</head>
<body>
	<button type="button" onclick="history.back()" class="button">買い物を続ける</button>
	<input type="submit" value="購入に進む" name="regist" class="button">
	<form action="/ECSite/Cart_itemServlet" method="get">
		<input type="submit" value="買い物カゴをみる" name="regist" class="button">
	</form>
</body>
</html>