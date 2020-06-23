<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<jsp:useBean id="loginBean" class="jp.co.aforce.beans.LoginBean" scope= "request" />



<!doctype html>
<html>
<head>
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- CSS -->
<link href="<c:url value="/css/member.css" />" rel="stylesheet">


<!-- jquery呼び出し -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>

<title>メニュー画面</title>
</head>
<body>



		<form method="get" name="form1" action="/ECSite/RegistMServlet">
		<a href="javascript:form1.submit()">商品登録</a>

	</form>

	<form method="post" name="form2" action="/ECSite/ChangeMServlet">
		<a href="javascript:form2.submit()">商品変更</a>

	</form>

	<form method="post" name="form3" action="/ECSite/DeleteMServlet">
		<a href="javascript:form3.submit()">商品削除</a>
	</form>

	<form method="get" name="form4" action="/ECSite/LogoutServlet">
		<a href="javascript:form4.submit()">ログアウト</a>
	</form>

	<script src="/js/header.js"></script>
</body>
</html>
