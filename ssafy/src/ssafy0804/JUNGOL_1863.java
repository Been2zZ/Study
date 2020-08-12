package ssafy0804;

import java.util.Scanner;

/**
 * 
 * @ClassName JUNGOL_1863.java
 * @author  JEONG SUBEEN
 *
 * @since 2020. 8. 4.
 * @version 1.0
 * 
 * @title -> 종교
 */
public class JUNGOL_1863 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] p = new int[n + 1];
		
		for (int i = 1; i <= n; i++)
			p[i] = i;
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			union(p, a, b);
		}

		int cnt = 0;
		
		for (int i = 1; i <= n; i++) 
			if (p[i] == i) 
				cnt++;
		
		System.out.println(cnt);
	}
	
	public static int find(int[] p, int a) { 
		if(p[a] == a) 
			return a; 
		else 
			return p[a] = find(p, p[a]); 	 
	} 

	public static void union(int[] p, int a, int b) {
		a = find(p, a);		// a의 부모 
		b = find(p, b); 	// b의 부모
		
		if (a != b)
			p[b] = a;		// b의 부모는 a
	} 
}
