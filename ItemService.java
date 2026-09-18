package stockApp;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
	// データ保存
	private List<Item> itemList = new ArrayList<>();
	private int nextId = 1;

	// 枠組み
	public void showAll() {
		System.out.println("一覧表示の準備");
	}
}