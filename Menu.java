package stockApp;

import java.util.Scanner;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private ItemService itemService = new ItemService();

	///ループ処理　番号入力に応じて各操作を呼び出す(数字以外は弾く)
	public void start() {
		int choice = -1;

		while (choice != 0) {
			showMainMenu();
			System.out.print("番号を入力してください: ");

			///数字か文字列かの判別
			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();
				scanner.nextLine();

				if (choice == 1) {
					registerItem();
				} else if (choice == 2) {
					showListMenu();
				} else if (choice == 3) {
					updateItem();
				} else if (choice == 4) {
					removeItem();
				}
			}
			///数字でなかった場合
			else {
				System.out.println("メニューにある半角数字を入力してください。");
				scanner.nextLine();
			}
		}
	}

	/// メニューを表示
	public void showMainMenu() {
		System.out.println(" 1:登録 | 2:一覧 | 3:更新 | 4:削除 | 0:終了 ");
	}

	/// 新規登録メソッド　番号:1
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

	///一示表示メソッド 番号:2
	public void showListMenu() {
		System.out.println("一覧メニュー");
		System.out.println("1:全件表示");
		System.out.println("2:購入品レコメンド（残量少、なし）");
		System.out.println("番号を入力してください: ");

		int subChoice = scanner.nextInt();
		scanner.nextLine();

		if (subChoice == 1) {
			showAll();
		} else if (subChoice == 2) {
			showRecommendItem();
		}
	}

	// 全件表示の処理
	public void showAll() {
		System.out.println("在庫一覧");
		itemService.showAll();
	}

	// レコメンド表示の処理
	public void showRecommendItem() {
		System.out.println("在庫切れリスト");
		itemService.showRecommendItem();
	}

	///ステータス更新メソッド　番号:3
	public void updateItem() {
		System.out.println("ストック更新");
		System.out.println("更新したいストックのIDを入力してください: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.print("新しい品名: ");
		String newName = scanner.nextLine();

		System.out.print("新しい残量(0:なし, 1:残りわずか, 2:十分): ");
		int newStatus = scanner.nextInt();
		scanner.nextLine();

		System.out.print("新しいメモ: ");
		String newMemo = scanner.nextLine();

		// ItemServiceの新しい更新メソッドに渡す
		itemService.updateItem(id, newName, newStatus, newMemo);
	}

	/// 削除メソッド 番号:4
	public void removeItem() {
		System.out.println("ストック削除");
		System.out.print("削除したいストックのIDを入力してください: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		itemService.deleteItem(id);
	}
}
