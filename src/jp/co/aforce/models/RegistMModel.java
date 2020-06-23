/*管理者画面→商品登録画面で商品登録を行う*/

package jp.co.aforce.models;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.aforce.util.DBUtil;

public class RegistMModel {

	public boolean regist_Check(String item_id, String item_name, String item_price, String item_category, String img) {
		//実行結果を格納する変数
		ResultSet rs = null;

		Date date = new Date();
		String item_i = new SimpleDateFormat("yyMMddHHmmss").format(date);
		String id = "A" + item_i;
		System.out.println(item_i);
		try {
			//DBに接続するための手続き
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			//★インサート
			String sql = "INSERT INTO `items` (`item_name`,`item_price`,`item_category`,`item_id`,`img`) VALUES ('"
					+ item_name + "','" + item_price + "','" + item_category + "','" + id + "','" + img + "')";
			//SQL実行
			System.out.println(sql);
			rs = DBUtil.execute(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return rs != null;
	}

	//★アップデート
	public boolean update(String item_id, String item_name, String item_price) {
		//実行結果を格納する変数
		ResultSet rs = null;

		//Date date = new Date();
		//String item_i = new SimpleDateFormat("yyMMddHHmmss").format(date);
		//String id = "A" + item_i;
		//System.out.println(item_i);
		try {
			//DBに接続するための手続き
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			//★アップデート
			String sqlU = "UPDATE `items` SET `item_name` = '" + item_name + "',"
					+ " `item_price` = '" + item_price + "' "
					+ " WHERE `item_id` = '" + item_id + "'";

			//SQL実行
			System.out.println(sqlU);
			rs = DBUtil.execute(sqlU);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return rs != null;

	}
}
