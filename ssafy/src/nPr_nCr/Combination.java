package nPr_nCr;

import java.util.Arrays;
import java.util.Scanner;

public class Combination {
	static int N,R;
	static int[] input,numbers;
	static int totalCount;
	
	// nCr
	// 6C3=6!/3!3!=20
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) 
			input[i] = sc.nextInt();
		
		combination(0,0);
		System.out.println("총 경우의 수 : " + totalCount);

		
	}
	private static void combination(int cnt,int cur) {
		if(cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=cur; i<N; ++i) {
			numbers[cnt] = input[i];
			combination(cnt+1,i+1);
		}
	}

}
