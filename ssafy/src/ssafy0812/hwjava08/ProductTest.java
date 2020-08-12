package ssafy0812.hwjava08;

import java.util.ArrayList;

public class ProductTest {

	public static void main(String[] args) {
		 ProductMgrImpl mgr = ProductMgrImpl.getInstance();

	        /**
	         * 상품 정보 저장
	         */
		 	try {
		 		 mgr.add(new TV(1, "Samsung display_QLED", 3000000, 128, "4K QLED", 72));
			     mgr.add(new TV(2, "Samsung display_LCD", 2100000, 18, "LCD", 21));
			     mgr.add(new Refrigerator(3, "Samsung Bespoke", 1800000, 322, 400));
			     mgr.add(new Refrigerator(4, "Samsung RB34K600", 1200000, 102, 600));
			     mgr.add(new Refrigerator(5, "Samsung T9000", 1700000, 78, 200));
			     mgr.add(new Refrigerator(6, "Samsung a001", 1670000, 11, 550));
			     mgr.add(new TV(7, "Samsung ledc0r3g2", 370000, 2, "LED", 32));
			     mgr.add(new TV(8, "Samsung led008ty", 3400000, 347, "LED", 60));
			     mgr.add(new TV(9, "Samsung display_0032", 190000, 140, "LCD", 18));
			     mgr.add(new Refrigerator(10, "Samsung b111", 890000, 131, 120));
			     mgr.add(new Refrigerator(11, "Samsung xyz", 4320000, 21, 890));				
			} catch (DuplicateException e) {
				System.out.println(e);
			}
	       
	        System.out.println("< 상품 정보 전체 검색 >");
	        /**
	         * 상품 정보 전체 검색
	         */
	        ArrayList<Product> products = mgr.getAllProduct();
	        for (Product p : products)
	            System.out.println(p);

	        System.out.println("\n< 상품 번호로 상품 검색 > -> num : 2");
	        /**
	         * 상품 번호로 상품 검색
	         */
	        try {
				mgr.searchNum(2);
			} catch (CodeNotFoundException e) {
				System.out.println(e);
			}

	        System.out.println("\n< 상품명으로 상품 검색 > -> name : 'dis'");
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
	            System.out.println(p);

	        System.out.println("\n< Refrigerator 정보만 검색 >");
	        /**
	         * Refrigerator 정보만 검색
	         */
	        products = mgr.getAllRefrigerator();
	        for (Product p : products)
	            System.out.println(p);

	        System.out.println("\n< 400L 이상의 Refrigerator 검색 >");
	        /**
	         * 400L 이상의 Refrigerator 검색 기능
	         */
	        try {
				products = mgr.getRefrigerator_400LUp();
				for (Product p : products)
					System.out.println(p);
			} catch (ProductNotFoundException e) {
				System.out.println(e);
			}
	        

	        System.out.println("\n< 50inch 이상의 TV 검색 >");
	        /**
	         * 50inch 이상의 TV 검색 기능
	         */
	        try {
				products = mgr.getTV_50inchUp();
		        for (Product p : products)
		            System.out.println(p);
			} catch (ProductNotFoundException e) {
				System.out.println(e);
			}

	        System.out.println("\n< 상품 번호와 가격을 입력받아 상품 가격을 변경 > -> num : 8, newPrice : 1000");
	        /**
	         * 상품 번호와 가격을 입력받아 상품 가격 변경 기능
	         */
	        Product mod_p = mgr.modPrice(8, 1000);
	        if (mod_p != null)
	            System.out.println(mod_p.toString());
	        else
	            System.out.println("상품번호에 해당하는 상품이 존재하지 않습니다.");

	        System.out.println("\n< 상품번호로 상품을 삭제하는 기능 > -> num : 4");
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
