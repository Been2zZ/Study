package ssafy0722;

/**
 * D1_2072_홀수만 더하기
 */

import java.util.Scanner;

public class Solution_D1_2072 {
	public static int T;
	public static int N = 10;
	public static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int sum = 0;
			
			int[] num = new int[N];
			
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
				if (num[i] % 2 == 1)
					sum += num[i];
			}
		
			Answer = sum;
			
			System.out.println("#" + t + " " + Answer); 
		}
	}

}
