/*カートに入れる*/

package jp.co.aforce.models;

import java.sql.ResultSet;

import jp.co.aforce.beans.CartInBean;
import jp.co.aforce.util.DBUtil;

public class CartInModel {

	public boolean cart(CartInBean cartInBean) {
		//実行結果を格納する変数
		ResultSet rs = null;

		/*	cartInBean.getCartIn_name();
			cartInBean.getCartIn_price();
			cartInBean.getCartIn_id();
			cartInBean.getCartIn_quantity();
			cartInBean.getCartIn_img();
		*/

		try {
			//DBに接続するための手続き
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			//★インサート
			String sql = "INSERT INTO cart_items (cart_name ,cart_price,cart_id,cart_quantity,img) SELECT '"
					+ cartInBean.getCartIn_name()
					+ "','"
					+ cartInBean.getCartIn_price()
					+ "','"
					+ cartInBean.getCartIn_id()
					+ "','"
					+ cartInBean.getCartIn_quantity()
					+ "','"
					+ cartInBean.getCartIn_img()
					+ "'"
					+ " FROM items WHERE item_id = '"
					+ cartInBean.getCartIn_id()
					+ "';";



			//getCartIn_name 命名規則なおす

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

	public boolean join(CartInBean cartInBean) {
		//実行結果を格納する変数
		ResultSet rs = null;

		/*	cartInBean.getCartIn_name();
			cartInBean.getCartIn_price();
			cartInBean.getCartIn_id();
			cartInBean.getCartIn_quantity();
			cartInBean.getCartIn_img();
		*/

		try {
			//DBに接続するための手続き
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			//★インサート
			String sql = "INSERT INTO cart_items (cart_name ,cart_price,cart_id,cart_quantity,img) SELECT '"
					+ cartInBean.getCartIn_name()
					+ "','"
					+ cartInBean.getCartIn_price()
					+ "','"
					+ cartInBean.getCartIn_id()
					+ "','"
					+ cartInBean.getCartIn_quantity()
					+ "','"
					+ cartInBean.getCartIn_img()
					+ "'"
					+ " FROM items WHERE item_id = '"
					+ cartInBean.getCartIn_id()
					+ "';";

			//getCartIn_name 命名規則なおす

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