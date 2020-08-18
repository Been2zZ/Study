package ssafy0805;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author JEONG SUBEEN
 * 
 * @title -> 토마토
 */
public class BOJ_7576 {
	static int[][] BOX;
	static int count;
	static int N, M;
	
	public static class tomato {
		int x;
		int y;
		
		public tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		BOX	= new int[N][M];
		
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < M; j++)
				BOX[i][j] = sc.nextInt();
		
		BFS();
	}
	
	
	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	private static void BFS() {
		
		Queue<tomato> q = new LinkedList<>();
		
		// 익은 토마토 -> 큐에 넣음
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < M; j++)
				if (BOX[i][j] == 1)		q.add(new tomato(i, j));
		
		
		while (!q.isEmpty()) {
			tomato t = q.poll();

			for (int d = 0; d < 4; d++) { 				// 4 : 4방향
				int nr = t.x + dr[d];
				int nc = t.y + dc[d];

				if (!check(nr, nc))						// 상하좌우 배열 경계 외부 (Index Out)
					continue; 							
				if (BOX[nr][nc] != 0) 	 				// 4방향 인접한 곳 0인 경우 (익지 않은 토마토)
					continue;
				
				BOX[nr][nc] = BOX[t.x][t.y] + 1;
				q.add(new tomato(nr, nc));
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (BOX[i][j] == 0) {			// 토마토가 모두 익지 않음
					System.out.println(-1);
					return;
				}
				max = Math.max(max, BOX[i][j]);
			}
		}
		System.out.println(max - 1);
	}

	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		else
			return false;
	}
	
}
