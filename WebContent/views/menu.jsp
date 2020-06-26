<!-- ヘッダー流用 -->
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
<link href="<c:url value="/css/menu.css"/>" rel="stylesheet">


<!-- jquery呼び出し -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


</head>


<body>

	<!-- メニューバー -->

	<script src="/js/header.js"></script>

	<ul class="nav">
		<li class="nav__item"><form method="post" name="form1"
				action="/ECSite/ItemServlet">
				<a href="javascript:form1.submit()" class="menu_font">ITEM</a>
			</form></li>
		<li class="nav__item"><form method="post" name="form2"
				action="/ECSite/LoginServet">
				<a href="javascript:form2.submit()" class="menu_font">LOGIN</a>
			</form></li>
		<li class="nav__item"><form method="get" name="form3"
				action="/ECSite/LogoutServlet">
				<a href="javascript:form3.submit()" class="menu_font">LOGOUT</a>
			</form></li>
		<li class="nav__item"><form method="post" name="form5"
				action="/views/top.jsp">
				<a href="javascript:form5.submit()" class="menu_font">TOP</a>
			</form></li>
	</ul>


	<script src="js/header.js"></script>

</body>



</html>