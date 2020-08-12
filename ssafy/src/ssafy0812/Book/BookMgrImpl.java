package ssafy0812.Book;

import java.util.ArrayList;
import java.util.List;

public class BookMgrImpl implements IBookMgr {

	private ArrayList<Book> books = new ArrayList<>();
	
	public BookMgrImpl() {
		books.clear();
	}
	
	@Override
	public void add(Book b) {
		books.add(b);
	}

	@Override
	public List<Book> search() {
		List<Book> bbs=books.subList(0, books.size());
	    return bbs;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		Book nb=new Book();
	    nb.setIsbn(isbn);
	    if(!books.contains(nb)) {// contains -> equals 
	        throw new ISBNNotFoundException(isbn+"는 존재하지 않습니다.");
	    }
	    
	    Book nns=null;
	    for (int i = 0; i < books.size(); i++) {
	        Book b=books.get(i);
	        if(b.getIsbn().equals(isbn)) {
	            nns=b;
	            break; 
	        }
	    }
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		  Book nb=new Book();
		    nb.setIsbn(isbn);
		    if(!books.contains(nb)) {// contains -> equals 
		        throw new ISBNNotFoundException(isbn+" 이 isbn은 존재하지 않습니다.");
		    }
		    Book nns=null;
		    for (int i = 0; i < books.size(); i++) {
		        Book b=books.get(i);
		        if(b.getIsbn().equals(isbn)) {
		            nns=b;
		            break; 
		        }
		    }
		    nns.setQuantity(nns.getQuantity()+quantity);
	}

	@Override
	public int getTotalAmount() {
		int tot=0;
	    for (int i = 0; i < books.size(); i++) {
	        Book b=books.get(i);
	        tot+=b.getQuantity()*b.getPrice();
	    }
	    return tot;
	}

}
