package ssafy0812.Book;

public class Book {
	 protected String isbn;
	    protected String title;
	    protected int price;
	    protected int quantity;
	    public Book() {}
	    public Book(String isbn, String title, int price, int quantity) {
	        super();
	        this.isbn = isbn;
	        this.title = title;
	        this.price = price;
	        this.quantity = quantity;
	    }
	    @Override
	    public String toString() {
	        return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", quantity=" + quantity + "]";
	    }
	    public String getIsbn() {
	        return isbn;
	    }
	    public void setIsbn(String isbn) {
	        this.isbn = isbn;
	    }
	    public String getTitle() {
	        return title;
	    }
	    public void setTitle(String title) {
	        this.title = title;
	    }
	    public int getPrice() {
	        return price;
	    }
	    public void setPrice(int price) {
	        this.price = price;
	    }
	    public int getQuantity() {
	        return quantity;
	    }
	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
	        return result;
	    }
	    @Override
	    public boolean equals(Object obj) {
	        Book other = (Book) obj;
	        if (isbn.equals(other.getIsbn())) {
	            return true;
	        } else return false;
	    }
}
