package ssafy0805;

import java.util.Scanner;

/**
 * 
 * @author JEONG SUBEEN
 * 
 * @title -> 요리사
 */
public class Solution_SW_4012 {
	static int T, N, Answer;
	static int[][] arr;
	static int R;
	static boolean[] b;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			R = N / 2;
			arr = new int[N+1][N+1];
			
			for (int i = 1; i <= N; i++) 
				for (int j = 1; j <= N; j++) 
					arr[i][j] = sc.nextInt();

			b = new boolean[N + 1];
			
			Answer = Integer.MAX_VALUE;
			nCr(1, 0);
			
			System.out.println("#" + t + " " + Answer);
		}
	}
	
	private static void nCr(int index, int cnt) {
		if(cnt > N / 2) return;
        if(index > N) return;
        
		if (cnt == R) {
			int sum_a = 0, sum_b = 0;
			
			for (int i = 1; i <= N; i++) {
				if (b[i]) 
					for (int j = 1; j <= N; j++) {
						if (b[j]) 
							sum_a += arr[i][j];
					}
				else 
					for (int j = 1; j <= N; j++) {
						if (!b[j]) 
							sum_b += arr[i][j];
					}
			}
			
			Answer = Math.min(Answer, Math.abs(sum_a - sum_b));
			return;
		}
		
		b[index] = true;
		nCr(index + 1, cnt + 1);
		
		b[index] = false;
		nCr(index + 1, cnt);
	}
}
