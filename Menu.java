package stockApp;

import java.util.Scanner;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private ItemService itemService = new ItemService();

	///ループ処理　番号入力に応じて各操作を呼び出す
	public void start() {
		int choice = -1;

		while (choice != 0) {
			showMainMenu();

			System.out.print("番号を入力してください: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			if (choice == 1) {
				registerItem();
			} else if (choice == 2) {
				System.out.println("一覧表示機能");
			} else if (choice == 3) {
				System.out.println("更新機能");
			} else if (choice == 4) {
				System.out.println("削除機能");
			}
		}
	}

	/// トップメニューを表示
	public void showMainMenu() {
		System.out.println(" 1:登録 | 2:一覧 | 3:更新 | 4:削除 | 0:終了 ");
	}

	/// 新規登録
	public void registerItem() {
		System.out.print("品名: ");
		String name = scanner.nextLine();

		System.out.print("カテゴリ: ");
		String category = scanner.nextLine();

		System.out.print("残量(0:なし, 1:残りわずか, 2:十分): ");
		int status = scanner.nextInt();

		scanner.nextLine();
		System.out.print("メモ: ");

		String memo = scanner.nextLine();

		itemService.addItem(name, category, status, memo);
	}
}