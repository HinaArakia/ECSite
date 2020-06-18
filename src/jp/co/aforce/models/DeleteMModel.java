package jp.co.aforce.models;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.aforce.util.DBUtil;

public class DeleteMModel {

	public boolean change_Check(String item_id, String item_name, String item_price, String item_category) {
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

			//★アップデート
			String sql = "DELETE FROM `items` WHERE (`item_id`,`item_name`,`item_price`,`item_category`) VALUES ('"
					+ id + "','" + item_name + "','" + item_price + "','" + item_category + "')";
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
}
