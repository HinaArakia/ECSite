	<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:useBean id="loginBean" class="jp.co.aforce.beans.LoginBean" scope= "request" />


<!doctype html>
<html>
<head>

<!-- CSS -->
<link href="<c:url value="/css/EC.css"/>" rel="stylesheet">

<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>OOさんのマイページ</title>
</head>
<body>
	<h1>Login</h1>
<div class="Login-form"><ul>
<h2>マイページ</h2>
	<form action="LoginServlet" method="POST">
	・会員情報変更
	</form>

	・購入履歴
	・退会


</div>

</body>
</html>