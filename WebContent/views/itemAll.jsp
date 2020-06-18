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
<link href="<c:url value="/css/TOP.css"/>" rel="stylesheet">
<!-- jquery呼び出し -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


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
			<c:out value="${getItems.img}" />
			個数: <select name="quantity">
				<option value="1">1
				<option value="2">2
				<option value="3">3
				<option value="4">4
				<option value="5">5
			</select> 個<br> <input type="submit" value="カートに追加">
		</form>
	</c:forEach>

</body>
</html>