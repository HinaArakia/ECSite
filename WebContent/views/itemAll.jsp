<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="itemBean" class="jp.co.aforce.beans.ItemBean"
	scope="request" />
<!DOCTYPE html>
<html>
<head>

<!-- CSS -->
<link href="<c:url value="/css/item.css"/>" rel="stylesheet">
<!-- jquery呼び出し -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<title>アイテム一覧ページ</title>

</head>
<body>
	<jsp:include page="/views/menu.jsp" />

	<div class="item"><br><br>ITEM</div>

	<!-- ★カテゴリー選択★ -->
	<form action="/ECSite/ItemServlet" method="POST">

		<select name="getItems">
			<option value=""></option>
			<option value="ファッション">ファッション</option>
			<option value="インテリア">インテリア</option>
			<option value="フード">フード</option>
			<option value="キッチン">キッチン</option>
			<option value="文具">文具</option>
		</select>
		&nbsp;
		<input type="submit" value="絞り込む" class="button">
	</form>

	<form action="/ECSite/SortServlet" method="POST">
		<select name="sort">
			<option value=""></option>
			<option value="high">high</option>
			<option value="low">low</option>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="検索" class="button">
	</form>

	<c:forEach items="${getItems}" var="getItems">
		<form action="/ECSite/CartInServlet" method="get">
					<img src="${pageContext.request.contextPath}/img/${getItems.img}"
						class="item_size" name="img" /><br> <br> <br> <br>
					<br> <br> <br> <br> <br> <br> <input
						type="hidden" name="item_name" value="${getItems.item_name}" /> <input
						type="hidden" name="item_price" value="${getItems.item_price}" />
					<input type="hidden" name="item_id" value="${getItems.item_id}" />
					<div class="item_name"><br>
					<c:out value="${getItems.item_name}" />
					</div>
					<!--<c:out value="${getItems.item_category}" />-->
					<div class="AllItem">
					<br> 価格:
					<c:out value="${getItems.item_price}" />
					円 <br> 個数: <select name="cart_quantity">
						<option value="1">1
						<option value="2">2
						<option value="3">3
						<option value="4">4
						<option value="5">5
					</select> 個 <br> <input type="submit" value="カートに追加"  class="button">
					</div>
		</form>
	</c:forEach>




	<script src="/js/header.js"></script>
</body>
</html>