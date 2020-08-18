package ssafy0812.Book;

public class ISBNNotFoundException extends Exception {
	public ISBNNotFoundException() {
	    this("이 ISBN 없음");
	}

	public ISBNNotFoundException(String message) {
	    super(message);
	}
}
