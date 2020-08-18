package ssafy0728;

import java.util.Scanner;

public class Solution_D2_1954 {
	static int T;
	static int N;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int index_i = 0;
			int index_j = -1;
			int tmp = 1;
			int num = 1;

			N = sc.nextInt();
			int[][] arr = new int[N][N];

			while (true) {
				for (int i = 0; i < N; i++) {
					index_j += tmp;
					arr[index_i][index_j] = num++;
				}

				N -= 1;

				if (N == 0)
					break;

				for (int i = 0; i < N; i++) {
					index_i += tmp;
					arr[index_i][index_j] = num++;
				}

				tmp *= -1;
			}

			System.out.println("#" + test_case);
			for (index_i = 0; index_i < arr.length; index_i++) {
				for (index_j = 0; index_j < arr.length; index_j++)
					System.out.print(arr[index_i][index_j] + " ");
				System.out.println();
			}
		}
	}

}
