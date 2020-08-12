package ssafy0731;

import java.util.Scanner;

public class Solution_D4_8659_dp {
	static int T;
	static int K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			K = sc.nextInt();
			long[][] DP = new long[K][2];
			
			DP[0][0] = 2;
			DP[0][1] = 1;
			
			for(int i = 1; i < K; i++) {
				DP[i][0] = DP[i-1][0] + DP[i-1][1];
				DP[i][1] = DP[i-1][0];
			}
			
			long A = DP[K-1][0];
			long B = DP[K-1][1];
			
			System.out.println("#" + t + " " + A + " " + B);
		}
	}
}
