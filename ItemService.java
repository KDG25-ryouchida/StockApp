package stockApp;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
	/// データ保存
	private List<Item> itemList = new ArrayList<>();
	private int nextId = 1;

	///データの登録メソッド　番号:1
	public void addItem(String name, String category, int status, String memo) {
		///新しいアイテムの作成、リストへの追加
		Item newItem = new Item(nextId, name, category, status, memo);
		itemList.add(newItem);
		System.out.println("ID" + nextId + name + "をストックに登録しました。");

		///次のアイテム用のID番号
		nextId++;

	}

	///一覧表示　番号:2
	///全件表示　番号:2-1
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
		if (!found) {
			System.out.println("現在、購入が必要なストックはありません。");

		}
	}
}