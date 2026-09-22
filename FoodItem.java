package stockApp;

public class FoodItem extends Item {

	///期限のある商品（食材など）用の追加データ
	private String expirationDate;///賞味期限

	///コンストラクタ
	public FoodItem(int id, String name, String category, int status, String memo, String expirationDate) {
		super(id, name, category, status, memo);
		this.expirationDate = expirationDate;
	}

	// 賞味期限のゲッターとセッター
	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String getItemInfo() {
		// super.getItemInfo()に賞味期限の文字を合体
		return super.getItemInfo() + " | 賞味期限:" + expirationDate;
	}
}
