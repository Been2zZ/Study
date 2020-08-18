package ssafy0723;

public class Refrigerator {
	/**
	 * 냉장고 정보 (제품 번호, 제품 이름, 가격, 수량, 용량) 표현하기 위한 class
	 * Constructor, Encapsulation, toString() 적용
	 */
	
	private int productId;
	private String productName;
	private int productPrice;
	private int productNum;
	private int RefrigeratorVolume;
	
	public Refrigerator() {
		
	}
	
	public Refrigerator(int productId, String productName, int productPrice, int productNum, int refrigeratorVolume) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productNum = productNum;
		this.RefrigeratorVolume = refrigeratorVolume;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public int getRefrigeratorVolume() {
		return RefrigeratorVolume;
	}

	public void setRefrigeratorVolume(int refrigeratorVolume) {
		RefrigeratorVolume = refrigeratorVolume;
	}

	@Override
	public String toString() {
		return "Refrigerator [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productNum=" + productNum + ", RefrigeratorVolume=" + RefrigeratorVolume + "]";
	}
	
}
