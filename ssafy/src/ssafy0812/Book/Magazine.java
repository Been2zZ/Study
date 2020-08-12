package ssafy0812.Book;

public class Magazine extends Book {
	private int month;

	public Magazine() {
	    super();
	}

	public Magazine(String isbn, String title, 
	        int price, int quantity) {
	    super(isbn, title, price, quantity);
	    this.month = month;
	}

	@Override
	public String toString() {
	    return "Magazine [month=" + month + ", isbn=" + isbn + ", title=" + title + ", price=" + price + ", quantity="
	            + quantity + "]";
	}

	public int getMonth() {
	    return month;
	}

	public void setMonth(int month) {
	    this.month = month;
	}
	
}
