//★商品一覧★

package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる

public class Buy_ItemServlet extends HttpServlet {

	//★GET★
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("get request");
		//フォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/buy_item.jsp");
		rDispatcher.forward(request, response);

	}

	//★POST★
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("post request");

		//文字エンコーディングの指定
		request.setCharacterEncoding("UTF-8");

		String forward_jsp = "/views/buy_item.jsp";
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);
	}

}