package ssafy0812.hwjava08;

public class DuplicateException extends Exception {
	/**
	 * - 상품정보(TV와 Refrigerator)를 저장
	 * 	-> 이미 존재하는 상품일경우, DuplicateException 발생
	 */
	public DuplicateException() {
	    this("이미 존재하는 상품입니다.");
	}

	public DuplicateException(String message) {
	    super(message);
	}
}
