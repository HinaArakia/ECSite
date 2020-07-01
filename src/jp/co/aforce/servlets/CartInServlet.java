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

		//セッション
		HttpSession session = request.getSession(false);
		//session.invalidate();

		// カートを作る準備（セッション領域の取得・右辺をリストに対応できるようキャストしている）
		CartInBean cartInBean = new CartInBean();
		//System.out.prinln(session.getAttribute("cartInBean") instanceof ArrayList<CartInBean> );
		//		if(session.getAttribute("cartInBean") instanceof CartInBean){
		//			System.out.println("castok");
		//		}

		//
		//List<CartInBean> cart_list = new ArrayList<CartInBean>();

		//最初に買い物かごセッションを取得
		String item_name = request.getParameter("item_name");
		String item_price = request.getParameter("item_price");
		String item_id = request.getParameter("item_id");
		String cart_quantity = request.getParameter("cart_quantity");
		String img = request.getParameter("img");
		int subTotal =Integer.parseInt(item_price)*Integer.parseInt(cart_quantity);
		System.out.println(item_price+cart_quantity);
		System.out.println(item_name);

		// ★２、取り出した情報を CartInBean に格納する
		//CartInBean cartInBean = new CartInBean();
		cartInBean.setCartIn_name(item_name);
		cartInBean.setCartIn_price(item_price);
		cartInBean.setCartIn_id(item_id);
		cartInBean.setCartIn_quantity(cart_quantity);
		cartInBean.setCartIn_img(img);
		cartInBean.setSubTotal(subTotal);


		//★カゴなら使わないかも
		//cartinmodelをインスタンス化
		//CartInModel cartInModel = new CartInModel();
		//boolean cart = cartInModel.cart(cartInBean);

		ArrayList<CartInBean> cart_list = (ArrayList<CartInBean>) session.getAttribute("cartInBean");

		// カートが無ければつくる
		if (cart_list == null) {
			cart_list = new ArrayList<>();
			cart_list.add(cartInBean);
			session.setAttribute("cartInBean", cart_list);
		}
		cart_list.add(cartInBean);
		session.setAttribute("cartInBean", cart_list);

		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/cart.jsp");
		rDispatcher.forward(request, response);

		//cartinmodelをインスタンス化
		//CartInModel cartInModel = new CartInModel();
		//boolean cart = cartInModel.cart(cartInBean);
		//int price = 0;
		//int count = 0;
		//List<Item> cart = (List<Item>) session.getAttribute("cart");
		//for (CartInBean item : cart) {
		//count += item.getCount();
		//System.out.println(count);
		//}


		//int number = Integer.parseInt(cart_list.get(i).getCartIn_quantity());
		//System.out.println(number);


		}


	//★POST★
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("post request");
		//文字エンコーディングの指定
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/cart_item.jsp");
		rDispatcher.forward(request, response);

	}
}