<!-- ★TOP画面★ -->


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

	<!-- スリック -->

<link rel="stylesheet" type="text/css" href="slick/slick-1.8.1/slick/slick.css">

<!-- タイトル -->
<title>ECサイトTOPページ</title>
</head>
<body>
	<jsp:include page="/views/header.jsp" />
<div class="fixed-bg bg01">
<div class=font2><h2>サマーセール開催中</h2></div>
	<div class=font><h1>  <br><br>TOP<br>SITE</h1></div>
</div>

<div class="scroll-bg bg-color01">
	<jsp:include page="/views/menu.jsp" />

	<div class=font1><h1><br><br>PICK UP</h1></div>

</div>

<div class="fixed-bg bg02">
</div>
<!-- スリック -->
<script type="text/javascript" src="slick/slick-1.8.1/slick/slick.min.js"></script>
	<script src="/ECSite/WebContent/js/header.js"></script>
</body>
</html>