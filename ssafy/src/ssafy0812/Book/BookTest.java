package ssafy0812.Book;

import java.util.List;

public class BookTest {

	public static void main(String[] args) {
		 IBookMgr mgr = new BookMgrImpl();
		    mgr.add(new Book("82-1234-121","Java를 아는가",28000,5));
		    mgr.add(new Book("82-1234-122","Python을 아는가",25000,4));
		    mgr.add(new Book("82-1234-123","C++을 아는가",25000,6));
		    
		    print(mgr.search());
		    
		    try {
		        mgr.sell("82-1234-121",3);
		    } catch (QuantityException e) {
		        System.out.println(e);
		    } catch (ISBNNotFoundException e) {
		        // TODO Auto-generated catch block
		        System.out.println(e);
		    }
		    try {
		        mgr.sell("82-1234-121", 3);
		    } catch (QuantityException e) {
		        System.out.println(e);
		    } catch (ISBNNotFoundException e) {
		        // TODO Auto-generated catch block
		        System.out.println(e);
		    }
		    print(mgr.search());
		    
		    try {
		        mgr.buy("82-1234-121", 7);
		    } catch (ISBNNotFoundException e) {
		        System.out.println(e);
		    }
		    print(mgr.search());
		    
		    System.out.println(mgr.getTotalAmount());
		}
		public static void print(List<Book> bs) {
		    System.out.println("-------------------------");
		    for(Book b:bs) {
		        System.out.println(b);
		    }
		}
	
}
