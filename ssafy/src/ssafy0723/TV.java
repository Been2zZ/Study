package ssafy0723;

public class TV {
	/**
	 * TV의 정보 (제품 번호, 제품 이름, 가격, 수량, 인치, 디스플레이 타입) 표현하기 위한 class
	 * Constructor, Encapsulation, toString() 적용
	 */
	
	private int productId;
	private String productName;
	private int productPrice;
	private int productNum;
	private int DisplayInch;
	private String DisplayType;
	
	public TV() {
		
	}
 	
	public TV(int productId, String productName, int productPrice, int productNum, int productSize, String displayType) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productNum = productNum;
		this.DisplayInch = productSize;
		this.DisplayType = displayType;
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

	public int getDisplayInch() {
		return DisplayInch;
	}

	public void setDisplayInch(int displayInch) {
		DisplayInch = displayInch;
	}

	public String getDisplayType() {
		return DisplayType;
	}

	public void setDisplayType(String displayType) {
		DisplayType = displayType;
	}

	@Override
	public String toString() {
		return "TV [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productNum=" + productNum + ", productSize=" + DisplayInch + ", DisplayType=" + DisplayType + "]";
	}
	
}
