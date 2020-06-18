/*package jp.co.aforce.beans;

public class UserBean {

	private String users;


	//★セッター(ユーザズ）
	public void setusers(String users) {
		this.users =users;
	}
	//★ゲッター(ユーザズ)
	public String getusers() {
		return users;


}
}

*/

package jp.co.aforce.beans;
import java.io.Serializable; //データの永続化
public class UserBean implements Serializable{
	/*private String data;*/
	private String password;
	private String username;

	//引数なしのデフォルトコンストラクタ
	public UserBean() {
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
		this.username =username;}}