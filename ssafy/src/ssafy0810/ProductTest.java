package ssafy0810;

public class ProductTest {

	public static void main(String[] args) {
		
		ProductMgr mgr = ProductMgr.getInstance();
		
		/**
		 * 상품 정보 저장
		 */
		mgr.add(new TV(1, "Samsung display_QLED", 3000000, 128, "4K QLED"));
		mgr.add(new TV(2, "Samsung display_LCD", 2100000, 18, "LCD"));
		mgr.add(new Refrigerator(3, "Samsung Bespoke", 1800000, 322, 55));
		mgr.add(new Refrigerator(4, "Samsung RB34K600", 1200000, 102, 60));
		mgr.add(new Refrigerator(5, "Samsung T9000", 1700000, 78, 45));

		System.out.println("< 상품 정보 전체 검색 >");
		/**
		 * 상품 정보 전체 검색
		 */
		Product[] products = mgr.getAllProduct();
		for (Product p : products)
			System.out.println(p);
		
		System.out.println("\n< 상품 번호로 상품 검색 >");
		/**
		 * 상품 번호로 상품 검색
		 */
		mgr.searchNum(2);
		
		System.out.println("\n< 상품명으로 상품 검색 >");
		/**
		 * 상품명으로 상품 검색
		 */
		mgr.searchName("dis");		// 부분 검색 가능
		
		System.out.println("\n< TV 정보만 검색 >");
		/**
		 * TV 정보만 검색
		 */
		products = mgr.getAllTV();
		for (Product p : products)
			if (p != null)
				System.out.println(p);
		
		System.out.println("\n< Refrigerator 정보만 검색 >");
		/**
		 * Refrigerator 정보만 검색
		 */
		products = mgr.getAllRefrigerator();
		for (Product p : products)
			if (p != null)
				System.out.println(p);
		
		System.out.println("\n< 상품번호로 상품을 삭제하는 기능 >");
		/**
		 * 상품번호로 상품을 삭제하는 기능
		 */
		mgr.delete(4);
		products = mgr.getAllProduct();
		for (Product p : products)
			System.out.println(p);
		
		System.out.println("\n< 전체 재고 상품 금액을 구하는 기능 >");
		/**
		 * 전체 재고 상품 금액을 구하는 기능
		 */
		System.out.println("총 재고 금액 : " + mgr.stockPrice() + " 원");
	}

}
