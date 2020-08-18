package ssafy0731;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze_BFS {

	static int H, W;
	static char[][] map;
	static int[][] visited;
	static int[] count;
	static int sr, sc, er, ec;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };// 상하좌우

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		H = scann.nextInt();
		W = scann.nextInt();
		map = new char[H][W];
		visited = new int[H][W]; // 추가하세요
		for (int i = 0; i < H; i++) {
			map[i] = scann.next().toCharArray();
		}
		// 1. start end location
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'S') {
					sr = i;
					sc = j;
				} else if (map[i][j] == 'G') {
					er = i;
					ec = j;
				}
			}
		}
		// BFS
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { sr, sc });// 시작점
		visited[sr][sc] = 0; // 1 2 3
		while (!que.isEmpty()) {
			int[] curr = que.poll();
			if (er == curr[0] && ec == curr[1]) { // end 지점 Game OVER
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if (!check(nr, nc)) {
					continue;
				}
				if ((map[nr][nc] == '.' || map[nr][nc] == 'G') && (visited[nr][nc] == 0)) {
					// 방금전 이동수+1
					visited[nr][nc] = visited[curr[0]][curr[1]] + 1;
					que.offer(new int[] { nr, nc }); // 새로운 지점으로 이동
				}
			}
		}
		System.out.println(visited[er][ec]); // end 지점까지 이동값
	}

	private static boolean check(int r, int c) {
		if (r >= 0 && r < H && c >= 0 && c < W) {
			return true;
		} else
			return false;
	}
}