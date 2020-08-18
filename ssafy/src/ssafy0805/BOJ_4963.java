package ssafy0805;

import java.util.Scanner;

/**
 * 
 * @author JEONG SUBEEN
 *
 * @title -> 섬의 개수
 */
public class BOJ_4963 {
	static int w, h;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			if (w == 0 && h == 0) 
				break;
			
			map = new int[h + 2][w + 2];

			for (int i = 1; i <= h; i++) 
				for (int j = 1; j <= w; j++) 
					map[i][j] = sc.nextInt();

			/**
			 * 1 : 땅
			 * 0 : 바다
			 */
			
			int cnt = 0;
			for (int i = 1; i <= h; i++)
				for (int j = 1; j <= w; j++)
					if (map[i][j] == 1) 
						dfs(i, j, ++cnt + 1);
					
			System.out.println(cnt); 			// 섬 개수
		}
	}

	// 8방
	static int[] dr = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int[] dc = { -1, -1, -1, 0, 0, 1, 1, 1 };

	private static void dfs(int r, int c, int cnt) {
		map[r][c] = cnt;

		for (int d = 0; d < 8; d++) { // 8방향
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (!check(nr, nc))
				continue;

			if (map[nr][nc] == 1)
				dfs(nr, nc, cnt);
		}
	}

	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < h + 2 && nc >= 0 && nc < w + 2)
			return true;
		else
			return false;
	}

}
