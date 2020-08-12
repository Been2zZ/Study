package ssafy0724.Product;

public class ProductMgr {
	
	/** Singleton */
	
	private static ProductMgr mgr = new ProductMgr();
	
	private ProductMgr() {		}
	
	public static ProductMgr getInstance() {	return mgr;	}
	
	/** Singleton */
	
	
	// 상품을 저장할 Product[] 생성
	private Product[] products = new Product[100];
	private int index;
	
	public void add(Product p) {
		// 상품을 저장하는 기능
		if (index >= 0 && index < 99)
			products[index++] = p;
	}
	
	public void list() {
		// 저장된 상품을 볼 수 있는 기능
		for (int i = 0; i < index; i++)
			System.out.println(products[i].toString());
	}
	
	public void list(int num) {
		// 상품번호로 검색하는 기능
		int chk = 0;
		
		for (int i = 0; i < index; i++) {
			if (products[i].getNum() == num) {
				chk = 1;
				System.out.println(products[i].toString());
				}
			}
		
		if (chk != 1)
			System.out.println("상품번호 " + num + " 과(와) 일치하는 상품이 존재하지 않습니다.");
	}
	
	public void delete(int num) {
		// 상품번호로 삭제하는 기능
		int j = 0, chk = 0;
		
		for (int i = 0; i < index; i++) {
			if (products[i].getNum() == num) {
				chk = 1;
				j = i;
				products[i] = null;
				System.out.println("상품번호 " + num + " 에 해당하는 상품을 삭제하였습니다.");
			}
		}
		
		if (chk == 1) {
			// index 이동
			for (int i = j ; i < index; i++)
				products[i] = products[i + 1];
			index--;
		} else {
			System.out.println("상품번호 " + num + " 과(와) 일치하는 상품이 존재하지 않습니다.");
		}
		
	}
	
	public void priceList(int price) {
		// 특정가격 이하의 상품만 검색하는 기능
		
		for (int i = 0; i < index; i++) {
			if (products[i].getPrice() <= price) {
				System.out.println(products[i].toString());
			}
		}
	}

}
