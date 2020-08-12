package ssafy0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861 {
	private static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] rooms = new int[N + 1][N + 1];
			count = new int[(N * N) + 1];

			StringTokenizer st = null;

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 1; j <= N; j++)
					rooms[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int k = rooms[i][j];
					count[k]++;
					dfs(rooms, i, j, k);
				}
			}

			int max = Integer.MIN_VALUE;
			int room = -1;

			for (int i = 1; i < count.length; i++) {
				if (count[i] > max) {
					max = count[i];
					room = i;
				}
			}
			System.out.println("#" + t + " " + room + " " + max);
		}
	}

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	private static void dfs(int[][] map, int r, int c, int idx) {
		for (int d = 0; d < 4; d++) { 				// 4 : 4방향
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (!check(nr, nc, map.length))
				continue; 							// 상하좌우 배열 경계 외부 (Index Out)

			if (map[r][c] + 1 == map[nr][nc]) { 	// 현재 방에 적힌 숫자보다 정확히 1 큰 경우
				count[idx]++;
				dfs(map, nr, nc, idx);
			}
		}
	}

	private static boolean check(int nr, int nc, int N) {
		if (nr >= 1 && nr < N && nc >= 1 && nc < N)
			return true;
		else
			return false;
	}

}
