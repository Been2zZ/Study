package nPr_nCr;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
	static int N,R;
	static int[] input,numbers;
	static boolean[] isSelected;
	static int totalCount;
	
	// nPr
	// 6P3 = 6*5*4 = 120
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) 
			input[i] = sc.nextInt();
		
		permutation(0);
		System.out.println("총 경우의 수 : " + totalCount);
	}
	
	public static void permutation(int cnt) {
		if(cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=1; i<=N; ++i) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
