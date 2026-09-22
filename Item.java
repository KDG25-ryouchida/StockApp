package stockApp;

public class Item {
	///フィールド
	private int id;
	private String name;
	private String category;
	private int status; /// 0:なし　1:残りわずあか　2:十分
	private String memo;

	///コンストラクタ
	public Item(int id, String name, String category, int status, String memo) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.status = status;
		this.memo = memo;
	}

	///残量を文字で返すメソッド
	public String getStatusLabel() {
		if (status == 2) {
			return "十分あり";
		} else if (status == 1) {
			return "残りわずか";
		} else {
			return "なし";
		}
	}

	///残量の有無の判断メソッド
	public boolean isRecommended() {
		if (status <= 1) {
			return true;
		} else {
			return false;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getItemInfo() {
		return "ID:" + id + " | 品名:" + name + " | カテゴリ:" + category + " | 状態:" + getStatusLabel() + " | メモ:" + memo;
	}

}
