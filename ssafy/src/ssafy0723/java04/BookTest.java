package ssafy0723.java04;

public class BookTest {

	public static void main(String[] args) {
		
		System.out.println("***************************************** 도서 목록 *****************************************");
		
		Book book1 = new Book("21424", "Java Pro", "김하나", "Jean.kr", 15000, "Java 기본문법");
		System.out.println(book1.toString());
		
		Book book2 = new Book();
		book2.setIsbn("35355");
		book2.setTitle("분석설계");
		book2.setAuthor("소나무");
		book2.setPublisher("Jean.kr");
		book2.setPrice(30000);
		book2.setDesc("SW 모델링");
		System.out.println(book2.toString());
		
		Magazine magazine1 = new Magazine("35535", "Java World", "편집부", "java.com", 7000, "첫걸음", 2018, 2);
		System.out.println(magazine1.toString());
	}

}
