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
<!-- ふぉんとあうぇさむ -->
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">

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
	<div class=font><h1>  <br><br>TOP<br>SITE</h1></div>
</div>

<div class="scroll-bg bg-color01">
	<jsp:include page="/views/menu.jsp" />

	<div class=font1><h1><br><br>PICK UP</h1></div>

</div>



<div class="fixed-bg bg02">

<div class="summer">
<a href="/ECSite/ItemServlet" class="summer">
<img src="img/summer.jpg" width="750" height="450" >
</a>
</div>

</div>


	<jsp:include page="/views/footer.jsp" />
<!-- スリック -->
<script type="text/javascript" src="slick/slick-1.8.1/slick/slick.min.js"></script>
	<script src="/ECSite/WebContent/js/header.js"></script>
</body>
</html>