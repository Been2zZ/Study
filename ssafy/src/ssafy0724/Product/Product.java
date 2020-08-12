package ssafy0724.Product;

public class Product {
	/**
	 * 상품번호, 상품이름, 가격, 수량, 정보 저장
	 * Construtor, Encapsulator, toString() 적용
	 */
	private int num;
	private String name;
	private int price;
	private int count;
	
	public Product() {}

	public Product(int num, String name, int price, int count) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Product [ 상품번호 : " + num + ", 상품 이름 : " + name + ", 가격 : " + price + ", 수량 : " + count + " ]";
	}
	
}
