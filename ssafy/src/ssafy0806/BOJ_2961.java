package ssafy0806;

import java.util.Scanner;

/**
 * 
 * @ClassName BOJ_2961.java
 * @author  JEONG SUBEEN
 *
 * @since 2020. 8. 6.
 * @version 1.0
 * 
 * @title -> 도영이가 만든 맛있는 음식
 */
public class BOJ_2961 {
	static int[][] arr;
	static boolean[] visited;
	static int N, MIN;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[2][N];
		visited = new boolean[N];
		MIN = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			arr[0][i] = sc.nextInt();
			arr[1][i] = sc.nextInt();
		}
		
		recursion(0, 1, 0);
		System.out.println(MIN);
	}

	private static void recursion(int i, int j, int k) {
		int temp = Math.abs(j - k);
		if (i == N ) {
			if (MIN > temp && k != 0) 
				MIN = temp;
			return;
		}
		
		visited[i] = true;
		recursion(i + 1, j * arr[0][i], k + arr[1][i]);
		visited[i] = false;
		recursion(i + 1, j, k);
	}
}
