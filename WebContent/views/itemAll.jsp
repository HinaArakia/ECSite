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
<!-- ふぉんとあうぇさむ -->
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- jquery呼び出し -->
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<title>アイテム一覧ページ</title>

</head>
<body>
<jsp:include page="/views/header.jsp" />
	<jsp:include page="/views/menu.jsp" />

	<div class="item">ITEM</div>

	<!-- ★カテゴリー選択★ -->
	<form action="/ECSite/ItemServlet" method="POST">

		<select name="getItems">
			<option value=""></option>
			<option value="ファッション">ファッション</option>
			<option value="インテリア">インテリア</option>
			<option value="フード">フード</option>
			<option value="キッチン">キッチン</option>
			<option value="文具">文具</option>
		</select> &nbsp; <input type="submit" value="絞り込む" class="button">
	</form>

	<input type="button" class="sort_desc" value="価格の安い順"><br>
	<input type="button" class="sort_asc" value="価格の高い順" >



	<div id="item_list">
		<ul id="itemPage">
			<c:forEach items="${getItems}" var="getItems">
				<li>
					<form action="/ECSite/CartInServlet" method="get">
<img src="${pageContext.request.contextPath}/img/${getItems.img}"	class="item_size" name="img" />
							<input type="hidden" name="item_name" value="${getItems.item_name}" />
							<input type="hidden" name="item_price" value="${getItems.item_price}" />
				            <input type="hidden" name="item_id" value="${getItems.item_id}" />
					    	<div class="item_name">
							<br>
							<c:out value="${getItems.item_name}" />
						    </div>
						    <div class="AllItem">
							<br> 価格:
							<div>
						   ¥<span class="price"> <c:out value="${getItems.item_price}" /></span>
							</div>円 <br>
							個数:<select name="cart_quantity">
								<option value="1">1
								<option value="2">2
								<option value="3">3
								<option value="4">4
								<option value="5">5
							</select> 個 <br> <input type="submit" value="カートに追加" class="button">
						</div>
					</form>
				</li>
			</c:forEach>
		</ul>
	</div>

</body>
<script>
	$(function() {
		$(".sort_desc").click(
				function() { // class= "sort_desc" ボタンが押されたら実行
					$("#itemPage").html(
							// ul の中を並び替える
							$('#itemPage li').sort(
									function(a, b) { // li 要素を取得しソートする
										/* a, b という変数には li 要素が入っている
										   a, b それぞれの li 要素から class="price" の要素を見つけ、
										   テキストを抽出し 昇順に並び替える*/
										return ($(a).find(".price").text() - $(
												b).find(".price").text());
									}));
				});
	});

	$(function() {
		$(".sort_asc").click(
				function() {
					$("#itemPage").html(
							$('#itemPage li').sort(
									function(a, b) {
										// 昇順とは逆の式で、降順に並び替える
										return ($(b).find(".price").text() - $(
												a).find(".price").text());
									}));
				});
	});
</script>

</html>