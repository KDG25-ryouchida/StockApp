package stockApp;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
	/// データ保存
	private List<Item> itemList = new ArrayList<>();
	private int nextId = 1;

	///データの登録機能　番号:1
	public void addItem(String name, String category, int status, String memo) {
		///新しいアイテムの作成、リストへの追加
		Item newItem = new Item(nextId, name, category, status, memo);
		itemList.add(newItem);
		System.out.println("ID" + nextId + name + "をストックに登録しました。");

		///次のアイテム用のID番号
		nextId++;

	}

	///一覧表示機能　番号:2

	///全件表示機能　番号:2-1
	public void showAll() {
		if (itemList.isEmpty()) {
			System.out.println("現在登録されているストックはありません");
		} else {
			System.out.println("ストック一覧");
			for (Item item : itemList) {
				System.out.println("ID: " + item.getId() + "名前: " + item.getName() + "カテゴリ: " + item.getCategory()
						+ "残量: " + item.getStatus() + "メモ: " + item.getMemo());
			}
		}
	}

	///購入品のレコメンド機能（残量少、無し）　番号2-2
	public void showRecommendItem() {
		if (itemList.isEmpty()) {
			System.out.println("現在登録されているストックはありません");
			return;
		}

		boolean found = false;
		System.out.println("購入品リスト");
		for (Item item : itemList) {
			if ((item.isRecommended())) {
				System.out.println("ID: " + item.getId() + "名前: " + item.getName() + "残量: " + item.getStatus());
				found = true;
			}
		}
		///レコメンドされた商品がない時
		if (!found) {
			System.out.println("現在、購入が必要なストックはありません。");

		}
	}

	///ステータス更新機能 番号:3
	public void updateStatus(int targetId, int newStatus) {
		boolean found = false;

		for (Item item : itemList) {
			if (item.getId() == targetId) {
				item.setStatus(newStatus);
				System.out.println("ID: " + targetId + "の" + item.getName() + "の残量を更新しました。");
				found = true;
				break;
			}
		}
		///入力された番号が見つからなかった時
		if (!found) {
			System.out.println("指定されたIDのストックは見つかりませんでした。");
		}

	}

}