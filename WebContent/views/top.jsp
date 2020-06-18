<!-- ★TOP画面★ -->


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
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- タイトル -->
<title>ECサイトTOPページ</title>
</head>



<body>
	<main>
		<div class="cd-fixed-bg cd-bg-1">
			<h1>TOP画面</h1>
		</div>

<jsp:include page="header.jsp" />

		<div class="cd-scrolling-bg cd-color-1">
			<div class="cd-container">
				<p>ランキング画面</p>
			</div>
		</div>

		<div class="cd-fixed-bg cd-bg-2">
			<h1>アイテム</h1>
		</div>

		<div class="cd-scrolling-bg cd-color-2">
			<div class="cd-container">
				<p>カテゴリー</p>
			</div>
		</div>
	</main>


	<title>アイテム一覧ページ</title>

</head>
<body>
	<jsp:include page="/views/header.jsp" />
	<h3>商品一覧</h3>

	<c:forEach items="${getItems}" var="getItems">
		<form action="/ECSite/ItemServlet" method="POST">

			商品id:
			<c:out value="${getItems.item_id}" />
			<br> 商品名:
			<c:out value="${getItems.item_name}" />
			<br> 価格:
			<c:out value="${getItems.item_price}" />
			<br>

			<img src="${pageContext.request.contextPath}/img/${getItems.img}" />

			個数: <select name="quantity">
				<option value="1">1
				<option value="2">2
				<option value="3">3
				<option value="4">4
				<option value="5">5
			</select> 個<br> <input type="submit" value="カートに追加">
		</form>
	</c:forEach>



	<script src="/js/EC.js"></script>

</body>
</html>