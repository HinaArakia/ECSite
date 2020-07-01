package jp.co.aforce.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.util.DBUtil;

public class SortModel {

	//全件表示する
	public List<ItemBean> getItems() {
		ResultSet rs = null;
		//listをインスタンス化
		List<ItemBean> getItems = new ArrayList<ItemBean>();
		try {
			//DBに接続するための手続き
			DBUtil.makeConnection();
			DBUtil.makeStatement();
			//★全ての商品を出力するSQL
			String SQL = "SELECT * FROM `items`";
			//SELECTを実行する
			rs = DBUtil.execute(SQL);
			rs.beforeFirst();
			System.out.println(SQL);
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

	//高い
	public List<ItemBean> high(String item_price) {
		//public boolean category(String item_category) {
		ResultSet rs = null;

		//listをインスタンス化
		List<ItemBean> getItems = new ArrayList<ItemBean>();

		try {

			//DBに接続するための手続き
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			//★高い順
			String HSQL = "SELECT * FROM `items` ORDER BY '" + item_price + "' DESC ";
			System.out.println(HSQL);
			rs = DBUtil.execute(HSQL);
			System.out.println(HSQL);
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
	//低い
	public List<ItemBean> low(String item_price) {
		//public boolean category(String item_category) {
		ResultSet rs = null;

		//listをインスタンス化
		List<ItemBean> low = new ArrayList<ItemBean>();
		try {

			//DBに接続するための手続き
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String LSQL = "SELECT * FROM `items` ORDER BY '" + item_price + "'";
			System.out.println(LSQL);
			rs = DBUtil.execute(LSQL);
			System.out.println(LSQL);

			while (rs.next()) {

				ItemBean itemBean = new ItemBean();
				itemBean.setItem_name(rs.getString("item_name"));
				itemBean.setItem_price(rs.getString("item_price"));
				itemBean.setItem_category(rs.getString("item_category"));
				itemBean.setItem_id(rs.getString("item_id"));
				itemBean.setImg(rs.getString("img"));
				low.add(itemBean);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return low;

	}

}
