//★カートに入れるサーブレット★

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

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる

public class CartInServlet extends HttpServlet {

	//★GET★
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("get request");
		//フォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/cart.jsp");
		rDispatcher.forward(request, response);

		//セッション
		HttpSession session = request.getSession();

		// カートを作る準備（セッション領域の取得・右辺をリストに対応できるようキャストしている）
		CartInBean cartInBean = new CartInBean();
		ArrayList<CartInBean> cart_list = (ArrayList<CartInBean>) session.getAttribute("cartInBean");

		//
		//List<CartInBean> cart_list = new ArrayList<CartInBean>();


		//最初に買い物かごセッションを取得

		String item_name = request.getParameter("item_name");
		String item_price = request.getParameter("item_price");
		String item_id = request.getParameter("item_id");
		String cart_quantity = request.getParameter("cart_quantity");
		String img = request.getParameter("img");

		// ★２、取り出した情報を CartInBean に格納する
		//CartInBean cartInBean = new CartInBean();

		cartInBean.setCartIn_name(item_name);
		cartInBean.setCartIn_price(item_price);
		cartInBean.setCartIn_id(item_id);
		cartInBean.setCartIn_quantity(cart_quantity);
		cartInBean.setCartIn_img(img);

		//★カゴなら使わないかも
		//cartinmodelをインスタンス化
		//CartInModel cartInModel = new CartInModel();
		//boolean cart = cartInModel.cart(cartInBean);

		// カートが無ければつくる
		if (cart_list == null) {
			cart_list = new ArrayList<>();
			//session.setAttribute("cartInBean", cart_list);
		}
		cart_list.add(cartInBean);
		session.setAttribute("cartInBean", cartInBean);

	}

	//★POST★
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("post request");

		//文字エンコーディングの指定
		request.setCharacterEncoding("UTF-8");

	}
}