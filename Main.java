package stockApp;

public class Main {
	public static void main(String[] args) {
		// Menu の機能を使えるように準備（インスタンス化）
		Menu menu = new Menu();

		// Menu のメインループを呼び出してアプリを起動
		menu.start();
	}
}