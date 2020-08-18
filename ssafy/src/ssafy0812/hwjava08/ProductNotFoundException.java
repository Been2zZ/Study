package ssafy0812.hwjava08;

public class ProductNotFoundException extends Exception {
/**
 * - 400L 이상의 Refrigerator 검색
 * - 50inch 이상의 TV검색
 * 		-> 상품이 존재하지 않을 경우, ProductNotFoundException 발생
 */
	public ProductNotFoundException() {
	    this("상품이 존재하지 않습니다.");
	}

	public ProductNotFoundException(String message) {
	    super(message);
	}
}
