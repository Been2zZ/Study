package ssafy0807;

import java.util.Scanner;
/**
 * 
 * @ClassName Solution_D4_7733_치즈도둑.java
 * @author  JEONG SUBEEN
 *
 * @since 2020. 8. 10.
 * @version 1.0
 * 
 * @title -> Solution_D4_7733_치즈도둑 (DFS)
 */
public class Solution_D4_7733_치즈도둑 {
	static int[][] arr;
	static int[][] visited;
	static int T, N, total, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < N; j++) 
					arr[i][j] = sc.nextInt();
			
			total = N * N;
			max = 1;								// 처음 시작시 덩어리 1!!!
			
			int day = 0;
			
			while (total != 0) { 					// ->하나씩 먹어 없앤다
				day++;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (arr[i][j] == day) {		// 날짜에 맞는 치즈
							arr[i][j] = 0;
							total--;
						}
					}
				}
				
				if (total == 0)
					break;

				visited = new int[N][N];	// 방문배열 초기화

				int cnt = 0;				// 치즈 덩어리 개수
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (arr[i][j] > 0 && visited[i][j] == 0) {
							dfs(i, j);
							cnt++;
						}
					}
				}
				if (cnt > max) 
					max = cnt;
			}

			System.out.println("#" + t + " " + max);
		}

	}
	
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void dfs(int x, int y) {
		visited[x][y] = 1;

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if (!check(nx, ny)) continue;
			
			if (arr[nx][ny] > 0 && visited[nx][ny] == 0) 
				dfs(nx, ny);
		}

	}

	private static boolean check(int nx, int ny) {
		return (nx >= 0 && nx < N && ny >= 0 && ny < N);
	}

}
