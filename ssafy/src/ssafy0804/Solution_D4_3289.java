package ssafy0804;

import java.util.Scanner;

/**
 * 
 * @ClassName Solution_D4_3289.java
 * @author JEONG SUBEEN
 *
 * @since 2020. 8. 4.
 * @version 1.0
 * 
 * @title -> 서로소 집합
 */
public class Solution_D4_3289 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			/**
			 * make set
			 */
			int[] p = new int[n + 1];
			for (int i = 1; i <= n; i++) 
				p[i] = i;

			System.out.print("#" + t + " ");
			
			for (int i = 0; i < m; i++) {
				int chk = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if (chk == 0)
					// 합집합
					union(p, a, b);
				else if (chk == 1)
					// 같은 집합에 포함되어 있는지 확인
					if (find(p, a) == find(p, b))
						System.out.print(1);
					else
						System.out.print(0);
			}
			System.out.println();
		}

	}
	
	public static void union(int[] p, int a, int b) {
		/**
		 * 합집합 연산
		 */
		a = find(p, a);		// a의 부모 
		b = find(p, b); 	// b의 부모
		
		p[b] = a;		// b의 부모는 a
	} 
	
	public static int find(int[] p, int a) { 
		/**
		 * 부모 찾기
		 */
		if(p[a] == a) 
			return a; 
		else 
			return p[a] = find(p, p[a]); 	 
	} 

}
