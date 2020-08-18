package ssafy0807;

import java.util.Scanner;

/**
 * 
 * @ClassName BOJ_2468_안전영역_DFS.java
 * @author  JEONG SUBEEN
 *
 * @since 2020. 8. 10.
 * @version 1.0
 * 
 * @title -> 안전영역
 */
public class BOJ_2468_안전영역_DFS {
	static int n;
	static int[][] map, visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map = new int[n][n];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				map[i][j] = sc.nextInt();
		
		int maxValue = 0;
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (map[i][j] > maxValue)
					maxValue = map[i][j];
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= maxValue; i++) 
			if (func(i) > max) 
				max = func(i);
		
		System.out.println(max);
		
	}
	
	private static int func(int h) {
		int cnt = 0;
		
		visited = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] > h && visited[i][j] == 0) {
					visited[i][j] = ++cnt;
					dfs(i, j, h);
				}
			}
		}
		
		return cnt;
	}

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	private static void dfs(int x, int y, int h) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (!check(nx, ny))	continue;
			
			if (map[nx][ny] > h && visited[nx][ny] == 0) {
				visited[nx][ny] = visited[x][y];
				dfs(nx, ny, h);
			}
		}
	}
	
	private static boolean check(int x, int y) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}
}
