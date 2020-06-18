<%@ page language="java" contentType="text/html charset=UTF-8" %>

<jsp:useBean id="login_user_bean" scope="session" class="jp.co.aforce.beans.UserBean"/>



<header>

    <p>

        ようこそ「<jsp:getProperty name="name" property="name" />」様

        <%-- Getのクエリで購入履歴かログアウトか判断させる --%>

        <a href="ShoppingServlet?submit=history">購入履歴</a>

        <a href="LoginServlet?submit=logout">ログアウト</a>

    </p>

</header>