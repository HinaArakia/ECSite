//★商品の中身が見れるサーブレット金額表示、数量変更・削除したい。
package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartInBean;

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる

public class Cart_itemServlet extends HttpServlet {

	//★GET★
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("get request");
		//フォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/cart_item.jsp");
		rDispatcher.forward(request, response);
		HttpSession session = request.getSession();
		CartInBean cartInBean = new CartInBean();
		//★CartInServletでカートに入れたアイテムを表示したい
		if (session == null) {
			System.out.println("<p>セッションは存在しません。開始します</p>");
			session = request.getSession();
		} else {
			System.out.println("カートに入れた商品を表示したい");
			request.getAttribute("cartInBean");
		}

	}

	//★POST★
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("post request");

		//文字エンコーディングの指定
		request.setCharacterEncoding("UTF-8");

		String forward_jsp = "/views/itemAll.jsp";
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);
	}

}