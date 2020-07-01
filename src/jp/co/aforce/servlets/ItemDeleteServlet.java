package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartInBean;

public class ItemDeleteServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// ログアウト画面にフォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/logoutS.jsp");
		rDispatcher.forward(request, response);
	}

	@Override
	// 文字のエンコードを UTF-8 とする。これがないと文字化け。
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");

		//セッション
		HttpSession session = request.getSession();

		//jspからリスクエストパラメータを取得
		String cartInId = request.getParameter("cartIn_id");

		//sessionの中身をListに取り出す。
	//	List<CartInBean> cartList = (List<CartInBean>) session.getAttribute("CartInBean");
		ArrayList<CartInBean> cartList = (ArrayList<CartInBean>) session.getAttribute("cartInBean");

		//取り出したListの中身をループ
		for (CartInBean cart : cartList) {
			//idを比較して、一致するものをリストから除去
			if (cartInId.equals(cart.getCartIn_id())) {
				//リストから削除
				cartList.remove(cart);
				break;
			}
		}
		//sessionに詰めなおす。
		session.setAttribute("cartInBean", cartList);

		//商品を消す
		//HttpSession session = request.getSession(true);
		//session.invalidate();

		//ログイン画面に遷移
		//response.sendRedirect("/ECSite/LoginServlet");
		// ログアウト画面にフォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/buy_item.jsp");
		rDispatcher.forward(request, response);
	}

}