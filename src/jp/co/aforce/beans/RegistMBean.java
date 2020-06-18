/*★管理者商品登録用ビーン★*/
package jp.co.aforce.beans;

import java.io.Serializable; //データの永続化

public class RegistMBean implements Serializable {
	/*private String data;*/
	private String item_name;
	private String item_price;
	private String item_category;
	private String item_id;
	private String nul;
	private String success;
	private String error;
	private String img;

	//引数なしのデフォルトコンストラクタ
	public RegistMBean() {
	}
	//ゲッター　データを使いたいときここを通す
	/*public String getData() {
		return data;}*/
	//●ゲッター:データを取得する●セッター:データを保管しており、必要な時にLoginServlet()に受け渡しする。

	//★ゲッター(商品名)
	public String getItem_name() {
		return item_name;
	}

	//★セッター(商品名)
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	//★ゲッター(商品価格)
	public String getItem_price() {
		return item_price;
	}

	//★セッター(商品価格)
	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}

	//★ゲッター(商品カテゴリ)
	public String getItem_category() {
		return item_category;
	}

	//★セッター(商品カテゴリ)
	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	//★ゲッター(商品id)PK
	public String getItem_id() {
		return item_id;
	}

	//★セッター(商品id)PK
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}


	//★ゲッター(商品id)PK
		public String getImg() {
			return img;
		}

		//★セッター(商品id)PK
		public void setImg(String img) {
			this.img = img;
		}
	//★ゲッター(ヌル)
	public String getNmsg() {
		return nul;
	}

	//★セッター(ヌル）
	public void setNmsg(String nul) {
		this.nul = nul;
	}

	//★ゲッター(成功)
	public String getSmsg() {
		return success;
	}

	//★セッター(成功）
	public void setSmsg(String success) {
		this.success = success;
	}

	//★ゲッター(失敗)
	public String getEmsg() {
		return error;
	}

	//★セッター(失敗）
	public void setEmsg(String error) {
		this.error = error;
	}

}