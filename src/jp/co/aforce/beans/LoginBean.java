package jp.co.aforce.beans;
import java.io.Serializable; //データの永続化
public class LoginBean implements Serializable{
	/*private String data;*/
	private String password;
	private String username;
	private String error;
	//引数なしのデフォルトコンストラクタ
	public LoginBean() {
	}
	//ゲッター　データを使いたいときここを通す
	/*public String getData() {
		return data;}*/
	//●ゲッター:データを取得する●セッター:データを保管しており、必要な時にLoginServlet()に受け渡しする。

	//★ゲッター(パスワード)
	public String getPassword() {
	return password;
	}
	//★セッター(パスワード）
	public void setPassword(String password) {
		this.password =password;
	}
	//★ゲッター(ユーザネーム)
	public String getUsername() {
		return username;
		}
	//★セッター（ユーザネーム）
	public void setUsername(String username) {
		this.username =username;
	}

	//★ゲッター(エラーメッセージ)
		public String getEmsg() {
		return error;
		}
		//★セッター(エラーメッセージ）
		public void setEmsg(String error) {
			this.error =error;
		}
}