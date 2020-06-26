//★商品を表示するサーブレット★

package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.models.ItemModel;

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる

public class ItemViewServlet extends HttpServlet {

	//★GET★
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("get request");
		//フォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/changeM.jsp");
		rDispatcher.forward(request, response);
	}

	//★POST★
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("post request");

		//文字エンコーディングの指定
		request.setCharacterEncoding("UTF-8");

		//itemモデルをインスタンス化
		ItemModel itemModel = new ItemModel();
		//★入力された値(item_id)があればそれを表示したい。

		//beanをインスタンス化
		ItemBean itemBean = new ItemBean();

		// ★１、管理者によって入力された情報を取り出す
		String item_price = request.getParameter("item_price");
		String item_name = request.getParameter("item_name");
		String item_category = request.getParameter("item_category");
		String item_id = request.getParameter("item_id");
		String img = request.getParameter("img");
		// ★２、取り出した情報を RegistMBean に格納する

		itemBean.setItem_price(item_price);
		itemBean.setItem_name(item_name);
		itemBean.setItem_category(item_category);
		itemBean.setItem_id(item_id);
		itemBean.setImg(img);

		itemBean.getItem_price();
		itemBean.getItem_name();
		itemBean.getItem_category();
		itemBean.getItem_id();
		itemBean.getImg();


		if(itemBean.getItem_id()==null) {
			//存在しなければエラーメッセージを表示
			itemBean.setEmsg("idが存在しません");
			request.setAttribute("registMsBean", itemBean);
		}
		else {

			//★全件表示する（モデルのメソッドを動かしたい）
			request.setAttribute("itemBean",itemBean);
		}

		String forward_jsp = "/views/changeM.jsp";
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);
	}

}