/*package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.util.DBUtil;

public class UserModel {

	//DB接続情報
	String USER = "username";
	String PASSWORD = "password";

	//追加
	public List<UserBean> getAllUsers() {

		Connection conn = null;
		ResultSet rs = null;

		try {

			//DBに接続するための手続き
		//	DBUtil.makeConnection();
			//DBUtil.makeStatement();

			//sqlを実行
			String SQL = "SELECT * FROM `login` ";
			//rs = DBUtil.execute(SQL);

			//Class.forName("com.mysql.jdbc.Driver").newInstance();
		//	conn = DriverManager.getConnection(USER, PASSWORD);

			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM login";

			while (rs.next()) {

				String password = rs.getString("password");
				String username = rs.getString("username");
				System.out.print("username:" + rs.getString("username") + ",password:" + rs.getString("password"));
				System.out.println();
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
		}
		return null;
	}
}

/*Statement st = null;
ResultSet rs = null;
PreparedStatement ps = null;

//宣言（user pass　
String user = "login";
String usern = "username";
String pass = "password";

return null;

try {
	//DBに接続するための手続き
	DBUtil.makeConnection();
	DBUtil.makeStatement();

	//sqlを実行
	String SQL = "SELECT * FROM `login` ";
	rs = DBUtil.execute(SQL);
			while(rs.next()) {
				//行からデータを取得
	    String users = rs.getString("users");
	    System.out.print("username:" +  rs.getString("username") + ",password:" + rs.getString("password"));
	    System.out.println();


	//データを取得

	}

} catch (Exception e) {
	e.printStackTrace();
} finally {
	DBUtil.closeConnection();

}
u
//リスト型のgetString

//ja ser next
//rsにデータが入っている。	resultsetは結果の取得。(22行目)
}
}*/