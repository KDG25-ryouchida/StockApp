package stockApp;

public class Item {
	///フィールド
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
		if(status == 2) {
			return "十分あり";
		}else if (status == 2) {
			return "残りわずか";
		}else {
			retrun "なし"
		}
	}

}
