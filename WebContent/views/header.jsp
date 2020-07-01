<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="itemBean" class="jp.co.aforce.beans.ItemBean"
	scope="request" />
<jsp:useBean id="loginBean" class="jp.co.aforce.beans.LoginBean"
	scope="request" />
<!DOCTYPE html>
<html>
<head>
<!-- CSS -->
<link href="<c:url value="/css/header.css"/>" rel="stylesheet">
<!-- ふぉんとあうぇさむ -->
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
<!-- jquery呼び出し -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>
<body>

<div class="box">
  <ul class="right">
    <li><a href="http://localhost:8080/ECSite/LoginServlet"><i class="fas fa-home"></i></a></li>
    <li><a href="http://localhost:8080/ECSite/LogoutServlet"><i class="fas fa-door-open"></i></a></li>
    <li><a href="http://localhost:8080/ECSite/Cart_itemServlet"><i class="fas fa-shopping-cart"></i></a></li>
  </ul>
</div>



</body>
</html>