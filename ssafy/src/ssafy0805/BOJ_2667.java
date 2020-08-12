package ssafy0805;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 * @author JEONG SUBEEN
 *
 * @title -> 단지번호붙이기
 */
public class BOJ_2667 {
	static int N;
	static int[][] map;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next().trim();
			for (int j = 0; j < N; j++)
				map[i][j] = (int) (str.charAt(j) - '0');
		}

		ArrayList<Integer> list = new ArrayList<>();

		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (map[i][j] == 1) {
					count = 0;
					cnt++;
					dfs(i, j);
					list.add(count);
				}

		System.out.println(cnt); 		// 단지 개수

		Collections.sort(list); 		// 오름차순
		for (Integer i : list)
			System.out.println(i); 		// 단지 내 집의 수

	}

	// 우좌 상하
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	private static void dfs(int r, int c) {
		map[r][c] = 0;
		count++;

		for (int d = 0; d < 4; d++) { 	// 4방향
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (!check(nr, nc))
				continue;

			if (map[nr][nc] == 1)
				dfs(nr, nc);
		}
	}

	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		else
			return false;
	}
}
