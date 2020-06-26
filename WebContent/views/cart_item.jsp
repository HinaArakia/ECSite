<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="cartInBean" class="jp.co.aforce.beans.CartInBean"
	scope="request" />

<%--コメントアウトした --%>
<%--@ page import="jp.co.aforce.beans.CartInBean"--%>
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

	<form action="/ECSite/CartInServlet" method="get">
		<%=cartInBean.getCartIn_name()%><br>
		<%=cartInBean.getCartIn_price()%>円<br>
		<%=cartInBean.getCartIn_quantity()%>個 <input type="hidden"
			name="item_name" value="${getItems.item_name} " readonly /> <input
			type="hidden" name="item_price" value="${getItems.item_price} "
			readonly /> <input type="hidden" name="item_id"
			value="${getItems.item_id} " readonly />
	</form>
	<div class="Login-form">
		<ul>
			<form action="/ECSite/Buy_ItemServlet" method="POST">
				<button type="button" onclick="history.back()" class="button">買い物を続ける</button>
				<input type="submit" value="購入に進む" name="regist" class="button">
			</form>
		</ul>
	</div>
</body>
</html>