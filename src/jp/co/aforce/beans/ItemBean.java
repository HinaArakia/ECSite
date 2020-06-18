//商品を格納するitembeanクラス

package jp.co.aforce.beans;

import java.io.Serializable;

public class ItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String item_name;
	private String item_category;
	private String item_price;
	private String item_id;
	private String img;


	public ItemBean() {
		this.item_name = "";
		this.item_category = "";
		this.item_price = "";
		this.item_id = "";
		this.img = "";

	}

	public ItemBean(String item_name, String item_category, String item_price, String item_id,String img) {
		this.item_name = item_name;
		this.item_category = item_category;
		this.item_price = item_price;
		this.item_id = item_id;
		this.img = img;
	}

	//★セッター(商品名)
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	//★ゲッター(商品名)
	public String getItem_name() {
		return this.item_name;
	}

	//★セッター(商品カテゴリ)
	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	//★ゲッター(商品カテゴリ)
	public String getItem_category() {
		return this.item_category;
	}

	//★セッター(商品価格)
	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}

	//★ゲッター(商品価格)
	public String getItem_price() {
		return this.item_price;
	}

	//★セッターPK(商品ID)
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	//★ゲッターPK(商品ID)
	public String getItem_id() {
		return this.item_id;
	}

	//★セッター(画像)
		public void setImg(String img) {
			this.img = img;
		}

		//★ゲッター(画像)
		public String getImg() {
			return this.img;
		}
}