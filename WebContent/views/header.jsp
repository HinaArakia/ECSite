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
<link href="<c:url value="/css/TOP.css"/>" rel="stylesheet">
<!-- jquery呼び出し -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">




</head>
<body>

	<header>
		<c:forEach items="${getItems}" var="getItems">
ようこそ<c:out value="${getItems.item_name}" />さん
</c:forEach>




	</header>

</body>
</html>