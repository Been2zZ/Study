package ssafy0806;

import java.util.Scanner;

/**
 * 
 * @ClassName Solution_D4_4301.java
 * @author  JEONG SUBEEN
 *
 * @since 2020. 8. 6.
 * @version 1.0
 * 
 * @title -> 콩 많이 심기
 */
public class Solution_D4_4301 {
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			map = new int[M][N];
			
			int cnt = 0;
			for (int i = M - 1; i >= 0; i--) {
				for (int j = N - 1; j >= 0; j--) {
					if (M - i > 2 && N - j > 2) {
						if (map[i + 2][j] == 0 && map[i][j + 2] == 0) {
						map[i][j] = 1;
						cnt++;
						}
					} else if (M - i <= 2 && N - j > 2) {
						if (map[i][j + 2] == 0) {
							map[i][j] = 1;
							cnt++;
							}
					} else if (M - i > 2 && N - j <= 2 ) {
						if (map[i + 2][j] == 0) {
							map[i][j] = 1;
							cnt++;
							}
					} else if (M - i <= 2 && N - j <= 2) {
						map[i][j] = 1;
						cnt++;
					}
					
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
		
	}

}
