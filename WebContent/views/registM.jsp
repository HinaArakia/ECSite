<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="registMBean" class="jp.co.aforce.beans.RegistMBean"
	scope="request" />



<!doctype html>
<html>
<head>
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- CSS -->
<link href="<c:url value="/css/member.css" />" rel="stylesheet">

<title>商品登録画面</title>

</head>
<body>
	s商品登録画面
	<br>
	<br>

	<div class="nameage">
		<form action="/ECSite/RegistMServlet" method="POST">
			<div class="text">
				商品名 <input type="text" name="item_name"><br> <br>
				商品価格 <input type="text" maxlength="5"
					oninput="value = value.replace(/[^0-9]+/i,'');" name="item_price" /><br>
				<br> 商品カテゴリ <select name="item_category"
					onSubmit="return check()">
					<option value=""></option>
					<option value="インテリア">インテリア</option>
					<option value="ファッション">ファッション</option>
					<option value="フード">フード</option>
					<option value="キッチン">キッチン</option>
					<option value="文具">文具</option>

				</select><br>
				<br> 商品画像<input type="text" name="img"><br> <br>

			</div>

			<div class="nameage">
				<button type="button" onclick="history.back()" class="button">戻る</button>
				<input type="submit" value="登録" name="regist" class="button">
			</div>

			<br>

			<!-- 未記入あり -->
			<c:out value="${memberBean.nmsg}" />
			<!-- 失敗時 -->
			<c:out value="${memberBean.emsg}" />
			<!-- 成功時 -->
			<c:out value="${memberBean.smsg}" />
		</form>



		<script src="/js/EC.js"></script>
	</div>
</body>
</html>