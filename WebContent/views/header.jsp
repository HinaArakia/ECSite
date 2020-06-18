<!-- ヘッダー流用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:useBean id="loginBean" class="jp.co.aforce.beans.LoginBean"
	scope="request" />

<jsp:useBean id="itemBean" class="jp.co.aforce.beans.ItemBean"
	scope="request" />

<!doctype html>
<html>
<head>


<!-- CSS -->
<link href="<c:url value="/css/TOP.css"/>" rel="stylesheet">


<!-- jquery呼び出し -->
<script type="text/javascript"src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


<!-- タイトル -->
<title>ECサイトTOPページ</title>
</head>


<body>

	<!-- メニューバー -->

	<div id="menu">
		<ul>
			<li><a href="#">HOME</a></li>
			<li><a href="/LoginServlet">LOGIN</a></li>
			<li><a href="/ECsite/LogoutServlet">LOGOUT</a></li>
			<li><a href="/ECsite/CartServlet">CART</a></li>
			<li><a href="/ECsite/ItemServlet">SERCH</a></li>

			<form method="post" name="form1" action="/ECsite/ItemServlet">
	 <a href="javascript:form1.submit()">ITEM</a>
</form>
		</ul>

		アイテム一覧表示

		<input type="submit" value="アイテム一覧" name="itemAll"
			onclick="location.href='/ECSite/ItemServlet'">

		<input type="submit" value="ログアウト" name="logout"
			onclick="location.href='/ECSite/LogoutServlet'" >
	</div>
	<div class="hidden_box">
		<label for="label1">🔍</label> <input type="checkbox" id="label1" />
		<div class="hidden_show">
			<!--非表示ここから-->
			<p>あいうえお</p>
			<!--ここまで-->
		</div>
	</div>
<script src="/js/EC.js"></script>
</body>



</html>