package ssafy0724.Movie;

import java.util.Arrays;

public class MovieMgr {
	/**
	 * 영화 정보를 저장, 검색, 관리할 MovieMgr 클래스 (Singleton Pattern 적용)
	 */
	
	private static MovieMgr movieMgr = new MovieMgr();
	
	private MovieMgr() {}
	
	public static MovieMgr getInstance() {
		return movieMgr;
	}
	
	private Movie[] movies = new Movie[100];
	private int index;
	
	/** 파라미터로 전달된 영화 정보를 전달받아 배열에 저장한다.*/
	public void add(Movie m) {
		if (index >= 0 && index < 99)
			movies[index++] = m;
	}
	
	/** 배열에 저장된 모든 영화정보를 리턴한다.*/
	public Movie[] search() {

//		* sol_v1 * 
//		Movie[] mm = new Movie[index];
//		for (int i = 0; i < index; i++) 
//			mm[i] = movies[i];
//		return mm;
		
//		* sol_v2 *
//		Movie[] mm = new Movie[index];
//		System.arraycopy(movies, 0, mm, 0, index);
//		return mm;
		
//		v1
		for (Movie movie : movies) 
			if (movie != null)
				System.out.println(movie.toString());
//		v2
//		for (int i = 0; i < index; i++)
//			System.out.println(movies[i].toString());
		
		return movies;
	}
	
	/** 파라미터로 전달된 타이틀을 포함하고 있는 모든 영화 정보를 검색하여 리턴한다*/
	public Movie[] search(String title) {	
		int chk = 0;
		
		for (int i = 0; i < index; i++) {
			if (movies[i].getTitle().equals(title)) {
				chk = 1;
				System.out.println(movies[i].toString());
				}
			}
		
		if (chk != 1)
			System.out.println(title + "과(와) 일치하는 영화 제목이 존재하지 않습니다.");
		
		return movies;
	}

	/** 파라미터로 전달된 감독명의 모든 영화 정보를 검색하여 리턴한다*/
	public Movie[] searchDirector(String name) {
		int chk = 0;
		
		for (int i = 0; i < index; i++) {
			if (movies[i].getDirector().equals(name)) {
				chk = 1;
				System.out.println(movies[i].toString());
				}
			}
		
		if (chk != 1)
			System.out.println(name + "과(와) 일치하는 영화 감독이 존재하지 않습니다.");
		
		return movies;
	}
	
	/** 파라미터로 전달된 장르의 모든 영화 정보를 검색하여 리턴한다*/
	public Movie[] searchGenre(String genre) {
		int chk = 0;
		
		for (int i = 0; i < index; i++) {
			if (movies[i].getGenre().equals(genre)) {
				chk = 1;
				System.out.println(movies[i].toString());
			}
		}
	
		if (chk != 1)
			System.out.println(genre + "과(와) 일치하는 영화 장르가 존재하지 않습니다.");
		
		return movies;
	}
	
	/** 파라미터로 전달된 제목의 영화를 삭제한다.*/
	public void delete(String title) {
		int j = 0;
		
		for (int i = 0; i < index; i++) {
			if (movies[i].getTitle().equals(title)) {
				j = i;
				movies[i] = null;
			}
		}
		
		// index 이동
		for (int i = j ; i < index; i++) 
			movies[i] = movies[i + 1];
		
		index--;
	}
	
	/** 저장된 영화 정보의 갯수를 리턴한다.*/
	public int getSize() {
		return index;
	}
}
