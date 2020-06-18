//購入履歴商品内容を格納するBean

package jp.co.aforce.beans;

import java.io.Serializable;

public class BuyHistoryBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String item_id_; // 商品ID
	private String item_name_; // 商品名
	private int item_quantity; // 購入した数

	public BuyHistoryBean() {
		this.item_id_ = "";
		this.item_name_ = "";
		this.item_quantity = 0;
	}

	public BuyHistoryBean(String item_id, String item_name, int item_quantity) {
		this.item_id_ = item_id;
		this.item_name_ = item_name;
		this.item_quantity = item_quantity;
	}

	public void setItemId(String item_id) {
		this.item_id_ = item_id;
	}

	public String getItemId() {
		return this.item_id_;
	}

	public void setItemName(String item_name) {
		this.item_name_ = item_name;
	}

	public String getItemName() {
		return this.item_name_;
	}

	public void setItemQuantity(int quantity) {
		this.item_quantity = quantity;
	}

	public int getItemQuantity() {
		return this.item_quantity;
	}

}