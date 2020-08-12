package ssafy0729;

import java.util.Scanner;

public class Solution_D3_1215 {
	static int T = 10, W = 8;
	static int N;
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			arr = new char[W][W];
			
			N = sc.nextInt();

			for (int i = 0; i < W; i++) {
				String str = sc.next().trim();
				for (int j = 0; j < W; j++) 
					arr[i][j] = str.charAt(j);
			}
			
			for (int i = 0; i < W; i++) {
				for (int j = 0; j <= W - N; j++) {
					String temp_X = "";
					String temp_Y = "";
					int count = j - 1;
					while (N + j <= W && count++ < N + j - 1) {
						temp_X += arr[i][count];
						temp_Y += arr[count][i];
					}
					Answer += sol(temp_X);
					Answer += sol(temp_Y);
				}
			}
			System.out.println("#" + test_case + " " + Answer);
		}
		
	}
	private static int sol(String temp) {
		int chk = 0;
		for (int i = 0; i < temp.length() / 2; i++) {
			if (temp.charAt(i) == temp.charAt(temp.length() -1 - i)) 
				chk = 1;
			else
				return 0;
		}
		return chk;
	}

}
