//★管理者画面　登録サーブレット★

package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.RegistMBean;
import jp.co.aforce.models.RegistMModel;

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる

public class RegistMServlet extends HttpServlet {

	//★GET★
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("get request");
		//フォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/registM.jsp");
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
		String item_price = request.getParameter("item_price");
		String item_name = request.getParameter("item_name");
		String item_category = request.getParameter("item_category");
		String item_id = request.getParameter("item_id");
		String img = request.getParameter("img");
		// ★２、取り出した情報を RegistMBean に格納する
		RegistMBean registMBean = new RegistMBean();
		registMBean.setItem_price(item_price);
		registMBean.setItem_name(item_name);
		registMBean.setItem_category(item_category);
		registMBean.setItem_id(item_id);
		registMBean.setImg(img);

		registMBean.getItem_price();
		registMBean.getItem_name();
		registMBean.getItem_category();
		registMBean.getItem_id();
		registMBean.getImg();
		RegistMModel registMModel = new RegistMModel();

		//★入力チェック★【if文】
		//★３入力チェック処理①（未記入）
		if (item_name == null || item_name.length() == 0 ||
				item_category == "" || item_category.length() == 0 ||
				item_price.length() == 0 || item_price == null) {
			registMBean.setNmsg("入力されていない項目があります");
			request.setAttribute("registMBean", registMBean);

		} else {
			//★boolean result 変数作る。
			boolean result = registMModel.regist_Check(item_id, item_name, item_price, item_category,img);

			if (result) {
				//★３入力チェック処理②（成功）
				registMBean.setSmsg("商品登録しました");
				request.setAttribute("registMBean", registMBean);

			} else {
				//★３入力チェック処理③（失敗）
				registMBean.setEmsg("商品登録に失敗しました");
				request.setAttribute("registMsBean", registMBean);
			}
		}
		String forward_jsp = "/views/RegistM.jsp";
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);
	}

}