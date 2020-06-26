
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:useBean id="loginBean" class="jp.co.aforce.beans.LoginBean"
	scope="request" />


<%@ page import="jp.co.aforce.beans.CartInBean"%>
<%
	//セッションスコープからインスタンスを取得![スクリーンショット 2016-02-25 13.43.01.png](https://qiita-image-store.s3.amazonaws.com/0/95187/871a7c0f-3793-0d1b-e24e-4cec9ae4cdf3.png)![スクリーンショット 2016-02-25 13.43.01.png](https://qiita-image-store.s3.amazonaws.com/0/95187/699aaea9-2ada-e7bc-bcd8-11b4c554c334.png)
CartInBean cartInBean = (CartInBean) session.getAttribute("cartInBean");
%>

<!doctype html>
<html>
<head>

<!-- CSS -->
<link href="<c:url value="/css/EC.css"/>" rel="stylesheet">

<!-- ふぉんとあうぇさむ -->
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet"　>

<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>入力フォーム</title>
</head>
<body>

	<div class="Login-form">
		<ul>

			<h2>購入アイテム確認</h2>
			以下の商品を購入します。
			<br>
			<%=cartInBean.getCartIn_name()%><br>
			<%=cartInBean.getCartIn_price()%>
			円
			<br>
			<%=cartInBean.getCartIn_quantity()%>
			個
			<br> 合計
			<%
				int sum = 0;
			for (int i = 0; i <= 10; i++) {
				sum = sum + i;
			}
			%>
			円<br>
			<input type="submit" value="購入する" name="regist" class="button">

			</form>
		</ul>
	</div>


	<p>
		<c:out value="${loginBean.emsg}" />
	</p>
</body>
</html>