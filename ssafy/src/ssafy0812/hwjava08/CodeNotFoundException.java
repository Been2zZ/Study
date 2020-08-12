package ssafy0812.hwjava08;

public class CodeNotFoundException extends Exception {
	/**
	 * - 상품번호로 상품을 검색하는 기능
	 * 	-> 상품 번호가 존재하지 않을 경우, CodeNotFoundException 발생
	 */
	public CodeNotFoundException() {
	    this("상품 번호가 존재하지 않습니다.");
	}

	public CodeNotFoundException(String message) {
	    super(message);
	}
}
