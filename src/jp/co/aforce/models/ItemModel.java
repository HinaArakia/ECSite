package jp.co.aforce.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.util.DBUtil;

public class ItemModel {

	//★全件表示★
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


	//★カテゴリ別★
	public List<ItemBean> category(String item_category) {
		//public boolean category(String item_category) {
		ResultSet rs = null;

		//listをインスタンス化
		List<ItemBean> getItems = new ArrayList<ItemBean>();

		try {

			//DBに接続するための手続き
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			//★カテゴリ別で検索する
			String CSQL = "SELECT * FROM `items` WHERE `item_category`='" + item_category + "'";
			System.out.println(CSQL);
			//SELECTを実行する
			rs = DBUtil.execute(CSQL);

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






		//★商品を高い順にソートするSQL
	public List<ItemBean> low(String item_price) {
		//public boolean category(String item_category) {
		ResultSet rs = null;

		//listをインスタンス化
		List<ItemBean> getItems = new ArrayList<ItemBean>();

		try {

			//DBに接続するための手続き
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			//★高い順
			String SQL = "SELECT * FROM `items` ORDER BY '" + item_price + "'";
			System.out.println(SQL);
			rs = DBUtil.execute(SQL);
			System.out.println(SQL);

			//★カテゴリ別で検索する
			/*String CSQL = "SELECT * FROM `items` WHERE `item_category`='" + item_category + "'";
			System.out.println(CSQL);
			//SELECTを実行する
			rs = DBUtil.execute(CSQL);*/

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
					String SQL = "SELECT * FROM `items` ORDER BY '" + item_price + "' DESC ";
					System.out.println(SQL);
					rs = DBUtil.execute(SQL);
					System.out.println(SQL);

					//★カテゴリ別で検索する
					/*String CSQL = "SELECT * FROM `items` WHERE `item_category`='" + item_category + "'";
					System.out.println(CSQL);
					//SELECTを実行する
					rs = DBUtil.execute(CSQL);*/

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


