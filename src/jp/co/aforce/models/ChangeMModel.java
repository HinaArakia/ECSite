package jp.co.aforce.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.util.DBUtil;

public class ChangeMModel {


	//★DBから商品テーブルの情報をselectする
	public List<ItemBean> getItems() {
		//実行結果を格納する変数
		ResultSet rs = null;
		//listをインスタンス化
		List<ItemBean> getItems = new ArrayList<ItemBean>();
		try {
			//DBに接続するための手続き
			DBUtil.makeConnection();
			DBUtil.makeStatement();
			//セレクト文
			String SQL = "SELECT * FROM `items` ";
			//SELECTを実行する
			rs = DBUtil.execute(SQL);
			//取得した結果を全件出力する
			while (rs.next()) {
				ItemBean itemBean = new ItemBean();
				itemBean.setItem_name(rs.getString("item_name"));
				itemBean.setItem_price(rs.getString("item_price"));
				itemBean.setItem_category(rs.getString("item_category"));
				itemBean.setItem_id(rs.getString("item_id"));
				itemBean.setImg(rs.getString("img"));
				getItems.add(itemBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return getItems;
	}
}