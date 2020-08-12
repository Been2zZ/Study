package ssafy0723;

public class ProductTest {
	/**
	 * 각 기능들을 테스트 할 수 있는 Test class
	 * main() 함수 구현
	 */
	public static void main(String[] args) {
		
		// TV 추가
		TV tv = new TV();
		tv.setProductId(10045);
		tv.setProductName("QLED_4K");
		tv.setProductPrice(3700000);
		tv.setProductNum(4200);
		tv.setDisplayInch(24);
		tv.setDisplayType("QLED");
		
		// 냉장고 추가
		Refrigerator refrigerator = new Refrigerator(20021, "비스포크", 226900, 1320, 871);
		
		// TV 정보 출력
		System.out.println(tv.toString() + "\n");
		
		// 냉장고 정보 출력
		System.out.println(refrigerator.toString());
		
	}
}
