
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:useBean id="loginBean" class="jp.co.aforce.beans.LoginBean"
	scope="request" />

<!doctype html>
<html>
<head>
<!-- CSS -->
<link href="<c:url value="/css/EC.css"/>" rel="stylesheet">

<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>カートの中身</title>
</head>
<body>
	<h1>ショッピングカート</h1>
	<div class='body'>
		<div class='container'>
			<p id="notice"></p>
			<h1>ショッピングカート</h1>
			<div class="col-lg-12">
				<table class="table table-hover table-inverse">
					<thead>

						<tr>
							<th>商品名</th>
							<th>単価(税込)</th>
							<th>数量</th>
							<th>小計</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<% @carts.each do |cart| %>
						<tr>
							<td><%= attachment_image_tag cart.product, :image, :fill, 30, 30 %><%= cart.product.name %></td>
							<td><%= number_to_currency(cart.product.price) %></td>
							<td><%= cart.quantity %></td>
							<td><%= number_to_currency(cart.product.price * cart.quantity) %></td>
							<td><%=link_to "削除する", cart_item_path(cart.id), method: :delete %></td>
							<td><%=link_to "カートを空にする", destroy_all_cart_items_path, method: :delete %></td>
							<% end %>
						</tr>
					</tbody>
				</table>
				<%= link_to "買い物を続ける", root_path %>
				<p>合計金</p>
			</div>
			<%= link_to "情報入力に進む", new_order_path %>
		</div>
	</div>
</body>
</html>