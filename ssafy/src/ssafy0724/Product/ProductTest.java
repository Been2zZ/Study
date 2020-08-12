package ssafy0724.Product;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ProductMgr mgr = ProductMgr.getInstance();
		
		int select;
		
		while (true) {
			System.out.println("<<< 재고 관리 프로그램 >>>");
			System.out.println("1. 상품 저장");
			System.out.println("2. 전체 상품 리스트");
			System.out.println("3. 상품 번호 검색");
			System.out.println("4. 상품 번호 삭제");
			System.out.println("5. 특정 가격 이하 상품 검색");
			System.out.println("0. 종료");
			
			select = sc.nextInt();
			
			if (select == 1) {
				System.out.println("1. 상품 저장");
				System.out.print("상품 번호 : ");
				int num = sc.nextInt();
				System.out.print("상품 이름 : ");
				String name = sc.next();
				System.out.print("가격 : ");
				int price = sc.nextInt();
				System.out.print("수량 : ");
				int count = sc.nextInt();
				mgr.add(new Product(num, name, price, count));
			} else if (select == 2) {
				System.out.println("2. 전체 상품 리스트");
				mgr.list();
			} else if (select == 3) {
				System.out.println("3. 상품 번호 검색");
				System.out.print("상품 번호 : ");
				int num = sc.nextInt();
				mgr.list(num);
			} else if (select == 4) {
				System.out.println("4. 상품 번호 삭제");
				System.out.print("상품 번호 : ");
				int num = sc.nextInt();
				mgr.delete(num);
			} else if (select == 5) {
				System.out.println("5. 특정 가격 이하 상품 검색");
				System.out.print("가격 : ");
				int price = sc.nextInt();
				mgr.priceList(price);
			} else if (select == 0) {
				break;
			}
			
		}
	}

}
