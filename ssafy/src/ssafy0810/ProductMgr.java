package ssafy0810;

public class ProductMgr {
/** Singleton */
	
	private static ProductMgr mgr = new ProductMgr();
	
	private ProductMgr() {		}
	
	public static ProductMgr getInstance() {	return mgr;	}
	
	/** Singleton */
	
	
	// 상품을 저장할 Product[] 생성
	private Product[] products = new Product[100];
	private int index;
	
	/**
	 * 상품정보(TV와 Refrigerator)를 객체 배열을 활용하여 저장
	 */
	public void add(Product p) {
		// 상품을 저장하는 기능
		if (p == null) return;
		if (index >= 0 && index < 99)
			products[index++] = p;
	}
	
	/**
	 * 상품정보 전체를 검색하는 기능
	 */
	public Product[] getAllProduct() {
		Product[] p = new Product[index];
		
		for (int i = 0; i < index; i++)
			p[i] = products[i];
		
		return p;
	}
	
	/**
	 * TV정보만 검색
	 */
	public Product[] getAllTV() {
		int cnt = 0;
		
		Product[] TV = new Product[index];
		
		for (int i = 0; i < index; i++) 
			if (products[i] instanceof TV)
				cnt++;
			
		for (int i = 0; i < cnt; i++) 
			if (products[i] instanceof TV)
				TV[i] = products[i];
		
		return TV;
	}
	
	/**
	 * Refrigerator만 검색
	 */
	public Product[] getAllRefrigerator() {
		int cnt = 0;
		
		Product[] Refrigerator = new Product[index];
		
		for (int i = 0; i < index; i++) 
			if (products[i] instanceof Refrigerator)
				cnt++;
			
		for (int i = 0; i < cnt; i++) 
			if (products[i] instanceof Refrigerator)
				Refrigerator[i] = products[i];
		
		return Refrigerator;
	}
	
	
	/**
	 * 상품번호로 상품을 검색하는 기능
	 */
	public void searchNum(int num) {
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
	
	/**
	 * 상품명으로 상품을 검색하는 기능(상품명 부분 검색 가능)
	 */
	public void searchName(String name) {
		// 상품명으로 상품을 검색하는 기능
		int chk = 0;
		
		for (int i = 0; i < index; i++) {
			String productName = products[i].getName();
			if (productName.contains(name)) {
				chk = 1;
				System.out.println(products[i].toString());
				}
			}
		
		if (chk != 1)
			System.out.println("상품이름 " + name + " 과(와) 일치하는 상품이 존재하지 않습니다.");
	}
	
	/**
	 * 상품번호로 상품을 삭제하는 기능
	 */
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
	
	/**
	 * 전체재고상품금액을구하는기능
	 */
	public int stockPrice() {
		int tv = 0, refrigerator = 0;
		for (int i = 0; i < index; i++) {
			if (products[i] instanceof TV) 
				tv += products[i].getCnt() * products[i].getPrice();
			else if(products[i] instanceof Refrigerator) 
				refrigerator += products[i].getCnt() * products[i].getPrice();
		}
		
		return tv + refrigerator;
	}
	
}
