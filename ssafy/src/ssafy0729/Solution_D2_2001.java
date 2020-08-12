package ssafy0729;

import java.util.Scanner;

public class Solution_D2_2001 {
	static int T;
	static int N, M;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			int sum = 0;
			int max = Integer.MIN_VALUE;
			
			for(int i=0;i<=N-M;i++) {
				for (int j = 0; j <=N-M; j++) {
					sum = 0;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (sum > max) {
						max = sum;
					}
					for (int p = 0; p < M && i + p < M; p++) {
						for (int q = 0; q < M && j + q < M; q++) {
							sum += map[i+p][j+q];
						}
					}
					sum = 0;
				}
			}
			
			Answer = max;
			
			System.out.println("#" + test_case + " " + Answer);
		}
	}
}
