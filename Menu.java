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
				showListMenu();
			} else if (choice == 3) {
				updateItemStatus();
			} else if (choice == 4) {
				System.out.println("削除機能");
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
	public void updateItemStatus() {
		System.out.println("ステータス更新");
		System.out.println("更新したいストックのITを入力してください");
		int id = scanner.nextInt();

		System.out.print("新しい残量(0:なし, 1:残りわずか, 2:十分): ");
		int newStatus = scanner.nextInt();
		scanner.nextLine();

		itemService.updateStatus(id, newStatus);
	}

}
