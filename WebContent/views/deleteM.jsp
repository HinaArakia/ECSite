<!-- ★管理者変更画面★ -->


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
<title>管理者削除画面</title>
</head>



<body>

	<h1>商品削除</h1>


	<c:forEach items="${getItems}" var="getItems">

		<form action="DeleteMServlet" method=post>
			商品id: <input type="text" value="${getItems.item_id}" name=item_id  /> <br>
			 商品名: <input type="text" value="${getItems.item_name}" name=item_name /> <br>
			価格: <input type="text" value="${getItems.item_price}" name=item_price readonly /> <br> 商品画像 <img
				src="${pageContext.request.contextPath}/img/${getItems.img}"class="item_size" />
				商品カテゴリ: <input type="text"value="${getItems.item_category}" name=item_category /> <br>



			<button type="submit">削除</button>
</form>
</c:forEach>



	<!-- 失敗時 -->
	<c:out value="${memberBean.emsg}" />





	<script src="/ECSite/WebContent/js/EC.js"></script>
</body>
</html>