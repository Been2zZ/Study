package ssafy0807;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @ClassName BOJ_2638_치즈.java
 * @author  JEONG SUBEEN
 *
 * @since 2020. 8. 10.
 * @version 1.0
 * 
 * @title -> 치즈
 */
public class BOJ_2638_치즈 {
	static int M, N;
	static int[][] map, visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();		// 열
		N = sc.nextInt();		// 행
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		
		int cnt = 0;
		boolean chk = true;
		
		while (chk) {
			visited = new int[N][N];
			bfs(0, 0);
			
			chk = false;				// 치즈 있는지 검사
			boolean bp = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0) {
						chk = true;
						bp = true;
						break;
					}
					if (bp) break;		// 이중 for loop 탈출
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {x, y});			// 시작점 x, y값 큐에 넣음
		
		while (!q.isEmpty()) {				// 큐가 빌때까지 반복
			int[] curr = q.poll();		
			int cx = curr[0];				// 현재 좌표
			int cy = curr[1];				// 현재 좌표
			
			for (int d = 0; d < 4; d++) {	// 4방향
				int nx = cx + dx[d];		// 다음 좌표
				int ny = cy + dy[d];		// 다음 좌표
				
				if (!check(nx, ny))	continue;	// 인덱스 아웃
				
				if (map[nx][ny] == 0 && visited[nx][ny] == 0) {	// 다음좌표 1이고 방문하지 않은 곳이면
					visited[nx][ny] = 1;
					q.add(new int[] {nx, ny});
				}
				if (map[nx][ny] == 1) {
					visited[nx][ny]++;
					if (visited[nx][ny] >= 2) 		// 2면 -> 녹음
						map[nx][ny] = 0;
				}
			}
		}
		
	}
	
	private static boolean check(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < M);
	}
}
