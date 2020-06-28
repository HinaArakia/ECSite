<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- jsp:useBean id="loginBean" class="jp.co.aforce.beans.LoginBean"
	scope="request" />--%>
<%@ page import="jp.co.aforce.beans.CartInBean"%>
<%--
	//セッションスコープからインスタンスを取得![スクリーンショット 2016-02-25 13.43.01.png](https://qiita-image-store.s3.amazonaws.com/0/95187/871a7c0f-3793-0d1b-e24e-4cec9ae4cdf3.png)![スクリーンショット 2016-02-25 13.43.01.png](https://qiita-image-store.s3.amazonaws.com/0/95187/699aaea9-2ada-e7bc-bcd8-11b4c554c334.png)
CartInBean cartInBean = (CartInBean) session.getAttribute("cartInBean");
--%>
<!doctype html>
<html>
<head>
<!-- CSS -->
<link href="<c:url value="/css/cart.css"/>" rel="stylesheet">
<!-- ふぉんとあうぇさむ -->
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>入力フォーム</title>
</head>
<body>
	<div class="Login-form">
		<ul>
			<h2>購入アイテム確認</h2>
			以下の商品を購入します。
			<c:forEach items="${cartInBean}" var="cartInBean">
				<form action="/ECSite/CartInServlet" method="get">
					${cartInBean.cartIn_name}<br> ${cartInBean.cartIn_price}円 ×
					${cartInBean.cartIn_quantity}個<br>
					<br> 小計<span class="subTotal">${cartInBean.subTotal}</span>円<br>
					<br>
				</form>

				<!-- 商品削除 -->
				<form action="/ECSite/ItemDeleteServlet" method="post">
					<input type="submit" value="削除" name="delete" class="button">
				</form>

				<input type="hidden" name="item_name" value="${getItems.item_name} "
					readonly />
				<input type="hidden" name="item_price"
					value="${getItems.item_price} " readonly />
				<input type="hidden" name="item_id" value="${getItems.item_id} "
					readonly />

			</c:forEach>
			<div class="total">合計</div>
			<form action=# name="form1" class="price"></form>
			<div class="yen">円</div>
			<form action="/ECSite/BuySuccesServlet" method="get">
				<input type="submit" value="購入する" name="regist" class="button">
				<input type="hidden" name="item_name" value="${getItems.item_name}" />
				<input type="hidden" name="item_price"
					value="${getItems.item_price}" /> <input type="hidden"
					name="item_id" value="${getItems.item_id}" />
			</form>
			<form action="/ECSite/ItemServlet" method="post">
				<input type="submit" value="商品一覧に戻る" name="regist" class="button">
			</form>
		</ul>
	</div>

	<script type="text/javascript">
		let targetElements = document.querySelectorAll(".subTotal");
		let total = 0;
		for (let i = 0; i < targetElements.length; i++) {
			total += Number(targetElements[i].textContent)
		}
		let element = document.createElement("p");
		element.innerText = total;
		document.form1.appendChild(element);
	</script>

</body>
</html>