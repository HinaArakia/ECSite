package jp.co.aforce.beans;

import java.io.Serializable; //データの永続化

public class CartInBean implements Serializable {
	/*private String data;*/
	public String cartIn_id;
	public String cartIn_name;
	public String cartIn_quantity;
	public String cartIn_price;
	public String cartIn_img;
	public String Smsg;
	public int subTotal;

	/**
	 *  subTotal
	 */
	public int getSubTotal() {
		return subTotal;
	}

	/**
	 * @param subTotal セットする subTotal
	 */
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * @return smsg
	 */
	public String getSmsg() {
		return Smsg;
	}



	/* @param emsg セットする emsg
	 */
	public void setSmsg(String Smsg) {
		this.Smsg = Smsg;
	}

	//引数なしのデフォルトコンストラクタ
	public CartInBean() {
	}
	//ゲッター　データを使いたいときここを通す
	/*public String getData() {
		return data;}*/
	//●ゲッター:データを取得する●セッター:データを保管しており、必要な時にLoginServlet()に受け渡しする。

	//★ゲッター(id)
	public String getCartIn_id() {
		return cartIn_id;
	}

	//★セッター(id）
	public void setCartIn_id(String cartIn_id) {
		this.cartIn_id = cartIn_id;
	}

	//★ゲッター(カート商品ネーム)
	public String getCartIn_name() {
		return cartIn_name;
	}

	//★セッター(カート商品ネーム)
	public void setCartIn_name(String cartIn_name) {
		this.cartIn_name = cartIn_name;
	}

	//★ゲッター(カート商品数)
	public String getCartIn_quantity() {
		return cartIn_quantity;
	}

	//★セッター(カート商品数)
	public void setCartIn_quantity(String cartIn_quantity) {
		this.cartIn_quantity = cartIn_quantity;
	}

	//★ゲッター(価格)
	public String getCartIn_price() {
		return cartIn_price;
	}

	//★セッター(価格）
	public void setCartIn_price(String cartIn_price) {
		this.cartIn_price = cartIn_price;
	}

	/**
	 * @return cartIn_img
	 */
	public String getCartIn_img() {
		return cartIn_img;
	}

	/**
	 * @param cartIn_img セットする cartIn_img
	 */
	public void setCartIn_img(String cartIn_img) {
		this.cartIn_img = cartIn_img;
	}



}