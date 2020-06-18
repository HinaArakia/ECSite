<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- CSS -->
<link href="<c:url value="/css/member.css" />" rel="stylesheet">


<title>メニュー画面</title>
</head>
<body>
	メニュー画面
	<div class=menu-form>
		<input type="submit" value="商品情報新規登録" name="regist"
			onclick="location.href='/ECSite/RegistMServlet'"> <br> <input


			type="submit" value="商品商品情報変更" name="change"
			onclick="location.href='/ECSite/ChangeMServlet'"><br> <input


			type="submit" value="商品情報削除" name="delete"
			onclick="location.href='/ECSite/DeleteMServlet'"> <input


			type="submit" value="ログアウト" name="regist"
			onclick="location.href='/ECSite/LogoutServlet'">

	</div>

</body>
</html>
