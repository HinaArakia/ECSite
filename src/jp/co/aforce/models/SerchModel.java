package jp.co.aforce.models;

import java.sql.ResultSet;

import jp.co.aforce.util.DBUtil;

public class SerchModel {

	/*
	 * 入力されたデータがDB上に存在するかどうかを調べる。
	 *
	  @param username ユーザ名
	  @param password パスワード
	  @return ログイン成功= true 失敗=false
	 */



	public boolean Serch(String item_category) {
		//実行結果を格納する変数
		ResultSet rs = null;

		try {
			//DBに接続するための手続き
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			//sqlを実行
			String SQL = "SELECT * FROM `items` WHERE `item_category`='" + item_category + "'";
			rs = DBUtil.execute(SQL);



		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return rs != null;
	}


}