
package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.models.RegistMModel;

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる

public class UpdateServlet extends HttpServlet {

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

		//一覧表示
		//ItemModel itemModel = new ItemModel();
		//List<ItemBean> getItems = itemModel.getItems();
		//request.setAttribute("getItems", getItems);

		//アップデート
		//モデルをインスタンス化
		RegistMModel registMModel = new RegistMModel();

		// ★１、ユーザによって入力された情報を取り出す
		String item_price = request.getParameter("item_price");
		String item_name = request.getParameter("item_name");
		//String item_category = request.getParameter("item_category");
		String item_id = request.getParameter("item_id");
		String img = request.getParameter("img");
		// ★２、取り出した情報を RegistMBean に格納する
		ItemBean itemBean = new ItemBean();
		itemBean.setItem_price(item_price);
		itemBean.setItem_name(item_name);
		//itemBean.setItem_category(item_category);
		itemBean.setItem_id(item_id);
		itemBean.setImg(img);

		itemBean.getItem_price();
		itemBean.getItem_name();
		//itemBean.getItem_category();
		itemBean.getItem_id();
		itemBean.getImg();


		registMModel.update(item_id, item_name, item_price);


		String forward_jsp = "/views/changeM.jsp";
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);
	}

}