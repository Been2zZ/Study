package ssafy0729;

import java.util.Scanner;

public class Solution_D3_2805 {
	static int T;
	static int N;
	static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			
			N = sc.nextInt();
			
			map = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = sc.next().trim();
				for (int j = 0; j < N; j++)
					map[i][j] = str.charAt(j);
			}
			
			int sum = 0;
			int index = N / 2; 
			
			for(int i = 0; i <= N / 2; i++) 
				for(int j = -i; j <= i; j++) 
					sum += map[i][index+j] - 48;
				
			for(int i = N / 2 + 1; i < N; i++) 
				for(int j = -(N - i - 1); j <= N - i - 1; j++) 
					sum += map[i][index+j] - 48;
				
			Answer = sum;
			
			System.out.println("#" + test_case + " " + Answer);
		}
	}

}
