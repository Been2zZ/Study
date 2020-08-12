package ssafy0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 
 * @author JEONG SUBEEN
 *
 * @title -> 염라대왕의 이름 정렬
 */
public class Solution_D4_7701 {
	static int T, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			TreeSet<String> tS = new TreeSet<>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() - o2.length() == 0)
						return o1.compareTo(o2);
					else
						return o1.length() - o2.length();
				}
				
			});
			
			N = Integer.parseInt(br.readLine().trim());
			
			for (int i = 0; i < N; i++) 
				tS.add(br.readLine().trim());
			
			System.out.println("#" + t);
			for (String string : tS) 
				System.out.println(string);
		}
	}

}
