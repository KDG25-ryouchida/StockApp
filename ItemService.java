package stockApp;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
	/// データ保存
	private List<Item> itemList = new ArrayList<>();
	private int nextId = 1;

	// 枠組み
	public void showAll() {
		///リストが空の時
		if (itemList.isEmpty()) {
			System.out.println("現在登録されているストックはありません");
		}
		///リストに登録されたものがある時
		else {
			System.out.println("ストック一覧");
			for (Item item : itemList) {
				System.out.println("ID" + item.getId() + "名前" + item.getName());
			}
		}
	}

	///データの登録メソッド
	public void addItem(String name, String category, int status, String memo) {
		///新しいアイテムの作成、リストへの追加
		Item newItem = new Item(nextId, name, category, status, memo);
		itemList.add(newItem);
		System.out.println("ID" + nextId + name + "をストックに登録しました。");

		///次のアイテム用のID番号
		nextId++;

	}

}