package ssafy0812;
/**
 * 
 * @author JEONG SUBEEN
 *
 * @title -> 삼각화단 만들기
 */

import java.util.Scanner;

public class Solution_삼각화단 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 0;
		
		for (int i = 0; i <= N; i++) {
			for (int j = i; i + j <= N; j++) {
				for (int k = j; i + j + k <= N; k++) {
					if (i + j + k == N && i + j > k && j + k > i && i + k > j) {
						count++;
						System.out.println(i + " " + j + " " + k);
					}
				}
			}
		}
		System.out.println(count);
	}
}
