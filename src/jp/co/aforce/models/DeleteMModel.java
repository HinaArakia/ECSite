package jp.co.aforce.models;

import java.sql.ResultSet;

import jp.co.aforce.util.DBUtil;

public class DeleteMModel {

	public boolean delete(String item_id, String item_name, String item_price, String item_category ,String img) {
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

			//★デリート
			String sql = "DELETE FROM `items` "
					+ "WHERE `item_id` = '" + item_id + "'";
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
