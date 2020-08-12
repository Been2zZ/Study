package ssafy0724.Movie;

import java.util.Scanner;

public class MovieTest {
	/**
	 * MovieMgr 클래스의 모든 메소드를 테스트 할 MovieTest 클래스
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MovieMgr mgr = MovieMgr.getInstance();
		
		int select;
		
		while (true) {
			System.out.println("<<< 영화 관리 프로그램 >>>");
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영화 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 영화감독 검색");
			System.out.println("5. 영화 장르별 검색");
			System.out.println("5. 영화 정보 삭제");
			System.out.println("0. 종료");
			
			select = sc.nextInt();
			
			if (select == 1) {
				Movie movie = null;				
				
				System.out.println("1. 영화 정보 입력");
				System.out.print("영화 제목 : ");
				String title = sc.next();
				System.out.print("영화 감독 : ");
				String director = sc.next();
				System.out.print("영화 등급 : ");
				int grade = sc.nextInt();
				System.out.print("영화 장르 : ");
				String genre = sc.next();
				System.out.println("영화 줄거리를 입력하시겠습니까? ");
				System.out.println("1. 입력");
				System.out.println("2. 생략");
				int inSummary = sc.nextInt();
				if (inSummary == 1) {
					System.out.print("영화 줄거리 : ");
					String summary = sc.next();
					movie = new Movie(title, director, grade, genre, summary);
				} else if (inSummary == 2) {
					movie = new Movie(title, director, grade, genre);
				}
				
				mgr.add(movie);
				
			} else if (select == 2) {
				System.out.println("2. 영화 정보 전체 검색");
				mgr.search();

//				* sol *
//				Movie[] mm = mgr.search();
//				for (Movie m : mm)
//					System.out.println(m);
				
			} else if (select == 3) {
				System.out.println("3. 영화명 검색");
				System.out.print("영화 제목 : ");
				String title = sc.next();
				mgr.search(title);
			} else if (select == 4) {
				System.out.println("4. 영화 감독별 검색");
				System.out.print("영화 감독 : ");
				String director = sc.next();
				mgr.searchDirector(director);
			} else if (select == 5) {
				System.out.println("5. 영화 장르별 검색");
				System.out.print("영화 장르 : ");
				String genre = sc.next();
				mgr.searchGenre(genre);
			} else if (select == 5) {
				System.out.println("5. 영화 정보 삭제");
				System.out.print("영화 제목 : ");
				String title = sc.next();
				mgr.delete(title);
			} else if (select == 0) {
				break;
			}
			
		}
	}

}
