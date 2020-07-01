<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- タグライブラリの使用を宣言（必要に応じて）  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- jsp:useBean id="loginBean" class="jp.co.aforce.beans.LoginBean"
	scope="request" />--%>
<%@ page import="jp.co.aforce.beans.CartInBean"%>
<%--
	//セッションスコープからインスタンスを取得![スクリーンショット 2016-02-25 13.43.01.png](https://qiita-image-store.s3.amazonaws.com/0/95187/871a7c0f-3793-0d1b-e24e-4cec9ae4cdf3.png)![スクリーンショット 2016-02-25 13.43.01.png](https://qiita-image-store.s3.amazonaws.com/0/95187/699aaea9-2ada-e7bc-bcd8-11b4c554c334.png)
CartInBean cartInBean = (CartInBean) session.getAttribute("cartInBean");
--%>
<!doctype html>
<html>
<head>
<!-- CSS -->
<link href="<c:url value="/css/cart.css"/>" rel="stylesheet">
<!-- ふぉんとあうぇさむ -->
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
<!-- 文字エンコーディングの指定 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>入力フォーム</title>
</head>
<body>
	<jsp:include page="/views/header.jsp" />
	<div class="Login-form">
		<ul>
			<div class="fontA">購入アイテム確認</div>


<ul id="wrap">
    <li class="box1 b"><p>確認</p></li>
    <li class="box1 a"><p>購入完了</p></li>

</ul>

			<div class="fontB">以下の商品を購入します。</div>

			<c:forEach items="${cartInBean}" var="cartInBean">
			${cartInBean.cartIn_name}



				<div class="item">
					<span>${cartInBean.cartIn_price}</span>円× <input type="text"
						value="${cartInBean.cartIn_quantity}"${cartInBean.cartIn_quantity}">個
					小計：<span class="subtotal">${cartInBean.subTotal}</span>
				</div>


				<form action="/ECSite/ItemDeleteServlet" method="post">
					<!-- 商品削除 -->
					<input type="hidden" name="cartIn_id"
						value="${cartInBean.cartIn_id}"> <input type="submit"
						value="削除" name="delete" class="button">
				</form>


				<input type="hidden" name="item_name" value="${getItems.item_name} "
					readonly />
				<input type="hidden" name="item_price"
					value="${getItems.item_price} " readonly />
				<input type="hidden" name="item_id" value="${getItems.item_id} "
					readonly />
			</c:forEach>

			<div class="font">合計：</div>
			<span id="total"></span>
						<div class="font">円</div>



			<form action="/ECSite/BuySuccesServlet" method="get">
				<input type="submit" value="購入する" name="regist" class="button">
				<input type="hidden" name="item_name" value="${getItems.item_name}" />
				<input type="hidden" name="item_price"
					value="${getItems.item_price}" /> <input type="hidden"
					name="item_id" value="${getItems.item_id}" />
			</form>
			<form action="/ECSite/ItemServlet" method="post">
				<input type="submit" value="商品一覧に戻る" name="regist" class="button">
			</form>
		</ul>
	</div>

	<%--script type="text/javascript"
		const targetElement = document.querySelector(".quantity");
		targetElement.addEventListener("change",(event))=> {
			const result = document.querySelector(".subtotal");
			result.textContent = "イベント発火";
		});
	/script--%>


	<script type="text/javascript">
    // class="item" という要素を全て取得
    const targetElements = document.querySelectorAll(".item");

    // 親要素を for 文で一つずつ取り出す。
    for (let i = 0; i < targetElements.length; i++) {
        /* 親要素内の input 要素を取り出し、イベントリスナを設定
           (getElementsByTagName は HTMLCollection で返ってくるため index0 を指定) */
        targetElements[i].getElementsByTagName("input")[0].addEventListener("change", (event) => {
            // input の中身を書き換え、確定したタイミングで以下の処理が実行される
            price = targetElements[i].getElementsByTagName("span")[0].textContent
            count = targetElements[i].getElementsByTagName("input")[0].value
            // 値段 * 個数の値で class="subtotal" の内容を書き換える
            targetElements[i].getElementsByClassName("subtotal")[0].innerHTML = price * count

            calcTotalPrice();
        })
    }
</script>

	<script type="text/javascript">

 function calcTotalPrice(){
    // subtotal というクラスの要素を全て取得し、配列で保持
    let targetElem = document.querySelectorAll('.subtotal');
    let total = 0;

    for (let i = 0; i < targetElem.length; i++) {
        // 取得した要素から内容を取り出し、total に足していく
        // textContent は文字列を返すので、数値にキャストする
        total += Number(targetElem[i].textContent)
    };
    // p要素を作成
    //let element = document.createElement('span')
    // 要素の内容に total を追加
    //element.innerText = total + "円"
    // id が total の要素の最後に p 要素を追加
    let span = document.getElementById('total')
    console.log(span)
    span.textContent = total};

 window.onload = function(){
	 calcTotalPrice();
 };
</script>



</body>
</html>