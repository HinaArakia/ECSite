package jp.co.aforce.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {


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




		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(true);
		session.invalidate();

		//ログイン画面に遷移
		response.sendRedirect("/ECSite/LoginServlet");
	}


}