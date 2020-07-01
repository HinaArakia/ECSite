//★商品一覧★

package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.models.SortModel;

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる

public class SortServlet extends HttpServlet {

	//★GET★
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("get request");
		//フォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/itemAll.jsp");
		rDispatcher.forward(request, response);
	}

	//★POST★
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("post request");

		//文字エンコーディングの指定
		request.setCharacterEncoding("UTF-8");

		// ★１、ユーザによって入力された情報を取り出す
		/*String item_price = request.getParameter("item_price");
		String item_name = request.getParameter("item_name");
		String item_category = request.getParameter("item_category");
		String item_id = request.getParameter("item_id");
		String img = request.getParameter("img");
		// ★２、取り出した情報をItemBean に格納する
		ItemBean itemBean = new ItemBean();
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
		*/

		//リクエストとってくる
		String sort = request.getParameter("sort");
		SortModel sortModel = new SortModel();
		//irwEMpty空文字もしくはnullだとtrueが返る↓
		if (sort=="") {
			List<ItemBean> getcategory= sortModel.getItems();
		request.setAttribute("getItems", getcategory);
		} else if(sort=="high") {
			List<ItemBean>  getcategory = sortModel.high(sort);
			request.setAttribute("high",getcategory);
		}
		else if(sort=="low") {
			List<ItemBean>  getcategory = sortModel.low(sort);
			request.setAttribute("low",getcategory);
		}

	//-------------------------------------

	//irwEMpty空文字もしくはnullだとtrueが返る↓
	///*	//if (getItems==null||getItems==""/*.isEmpty()*/) {
	/*		List<ItemBean> getcategory = sortModel.getItems();
		//"getitems"にgetcategoryにいれた値が入る。
		request.setAttribute("getItems", getcategory);
	}
	else if(getItems="high"){
		sortModel.high(item_price);
	}
	else if(getItems=="low"){
		sortModel.low(item_price);
	}
	*/
	//★ItemMOdelをインスタンス化*

	//List<ItemBean> getItems = itemModel.getItems();

	//★カテゴリ検索
	//item_category＝空の時はテーブルのカラム全件表示
	//if (item_category == "") {
	//request.setAttribute("getItems", getItems);
	//item_category＝ファッシションのカラムを全件表示
	//} else  {
	//item_category＝該当カテゴリのカラムを全件表示

	//getcategoryがif文の外だと使えないからnewする必要がある。
	//List<ItemBean> getcategory = new ArrayList<ItemBean>();
	//request.setAttribute("getItems", getcategory);
	//}

	String forward_jsp = "/views/itemAll.jsp";
	RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);rDispatcher.forward(request,response);
}

}