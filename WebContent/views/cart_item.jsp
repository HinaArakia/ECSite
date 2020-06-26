<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%--コメントアウトした --%>
<%@ page import="jp.co.aforce.beans.CartInBean"%>
<%@ page import="java.util.ArrayList"%>

<%--
	ArrayList<CartInBean> cart_list = new ArrayList<CartInBean>();
cart_list = (ArrayList<CartInBean>) session.getAttribute("cartInBean");
--%>

<%--	CartInBean cartInBean = (CartInBean) session.getAttribute("cartInBean");--%>
<!doctype html>
<html>
<head>
<!-- CSS -->
<link href="<c:url value="/css/EC.css"/>" rel="stylesheet">
<!-- ふぉんとあうぇさむ -->
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>カートの中身</title>
</head>
<body>
	<h1>カートの中身</h1>

	<c:forEach items="${cartInBean}" var="cartInBean">

		<form action="/ECSite/CartInServlet" method="get">

			${cartInBean.cartIn_name}<br>
			${cartInBean.cartIn_price}円<br>
			${cartInBean.cartIn_quantity}個
		</form>

		<input type="hidden" name="item_name" value="${getItems.item_name} "
			readonly />
		<input type="hidden" name="item_price" value="${getItems.item_price} "
			readonly />
		<input type="hidden" name="item_id" value="${getItems.item_id} "
			readonly />
	</c:forEach>
	<div class="Login-form">
		<ul>
			<button type="button" onclick="history.back()" class="button">買い物を続ける</button>

			<!-- 合計金額出したい -->
			<form action="/ECSite/Buy_ItemServlet" method="get">
				<input type="submit" value="購入に進む" name="regist" class="button">
			</form>
		</ul>
	</div>
</body>
</html>