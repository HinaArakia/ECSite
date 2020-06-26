package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.LoginBean;
import jp.co.aforce.models.LoginModel;

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class LoginServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// GETリクエストはあり得ないので、無条件でログイン画面に飛ばす
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/login.jsp");
		rDispatcher.forward(request, response);
		System.out.println("get request");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("post request");

		// 文字のエンコードを UTF-8 とする。これがないと文字化け。
		request.setCharacterEncoding("UTF-8");

		/* HttpSession session = request.getSession(false);

		    System.out.println("<html>");
		    System.out.println("<head>");
		    System.out.println("<title>セッションテスト</title>");
		    System.out.println("</head>");
		    System.out.println("<body>");

		    if (session == null){
		      System.out.println("<p>セッションは存在しません。開始します</p>");
		      session = request.getSession(true);
		    }else{
		      System.out.println("<p>セッション開始してます</p>");
		    }

		   // System.out.println("<a href=¥"/session/sessiontest¥">再表示</a>");

		    System.out.println("</body>");
		    System.out.println("</html>");*/

		//ItemModel itemModel = new ItemModel();
		//List<ItemBean> getItems = itemModel.getItems();
		//request.setAttribute("getItems", getItems);

		// ユーザによって入力された情報を取り出す
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//String user_id = request.getParameter("user_id");

		// 取り出した情報を loginBean に格納する
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);

		// モデルをインスタンス化する

		LoginModel loginModel = new LoginModel();
		String forward_jsp = "/views/login.jsp";

		// 入力された情報がDBに存在するか調べる
		if (!loginModel.loginCheck(username, password)) {
			// エラーメッセージを設定
			loginBean.setEmsg("ユーザ名またはパスワードが違います");
			request.setAttribute("loginBean", loginBean);
		} else if (username.equals("manager") && password.equals("manager")) {
			// 管理者ページに飛ぶ
			forward_jsp = "/views/menuM.jsp";
		} else {
			//ユーザーページに飛ぶ
			forward_jsp = "/views/top.jsp";
		}

		// forwaed_jsp に設定されているJSPへディスパッチ
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);
	}
}