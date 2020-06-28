//★カートに入れるサーブレット★

package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.CartInBean;
import jp.co.aforce.models.CartInModel;

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる

public class BuySuccesServlet extends HttpServlet {

	//★GET★
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("get request");

		//セッション
		//HttpSession session = request.getSession(false);
		//session.invalidate();

		CartInBean cartInBean = new CartInBean();

		//最初に買い物かごセッションを取得
		String item_name = request.getParameter("item_name");
		String item_price = request.getParameter("item_price");
		String item_id = request.getParameter("item_id");
		String cart_quantity = request.getParameter("cart_quantity");
		String img = request.getParameter("img");

		System.out.println(item_name);

		// ★２、取り出した情報を CartInBean に格納する
		//CartInBean cartInBean = new CartInBean();
		cartInBean.setCartIn_name(item_name);
		cartInBean.setCartIn_price(item_price);
		cartInBean.setCartIn_id(item_id);
		cartInBean.setCartIn_quantity(cart_quantity);
		cartInBean.setCartIn_img(img);

		//★カゴなら使わないかも
		//cartinmodelをインスタンス化
		//テーブルに入れる
		CartInModel cartInModel = new CartInModel();
		boolean cart = cartInModel.cart(cartInBean);
		request.setAttribute("cartInBean", cartInBean);

		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/buyS.jsp");
		rDispatcher.forward(request, response);

	}

	//★POST★
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("post request");
		//文字エンコーディングの指定
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/buyS.jsp");
		rDispatcher.forward(request, response);
	}
}