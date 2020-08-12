package ssafy0731;

import java.util.Scanner;

public class DuDu_DFS {
	static int N;
	static int[][] map;
	static int[] count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[N][N];
		count = new int[N];
		
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				map[i][j] = sc.nextInt();
		
		int cnt = 0;		// 군 (단지 A, B, C)
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				if (map[i][j] == 1) 	// 시작 점인지(첫번째 1이 나오면서부터)
					dfs(i, j, ++cnt + 1);	// 2단지, 3단지부터 시작 하려고
			
		// print
		System.out.println(cnt);		// 두더지굴 개수
		for (int i = 0; i < count.length; i++) 
			if (count[i] != 0) 
				System.out.println((count[i] + 1));
		
	}
	
	// 우좌 상하
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	// 재귀 -> call stack -> DFS (깊이 우선 탐색)
	private static void dfs(int r, int c, int cnt) {
		map[r][c] = cnt;					// 2단지, 3단지...
		
		for (int d = 0; d < 4; d++) {		// 4 : 4방향
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (!check(nr, nc)) continue;	// 상하좌우 배열 경계 외부 (Index Out)
			
			if (map[nr][nc] == 1) {
				count[cnt]++;				// group에 몇 개 들어가있는지 count -> 변수로 대체가능
				dfs(nr, nc, cnt);
			}
		}
	}

	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr <N && nc >= 0 && nc < N)
			return true;
		else	return false;
	}

}
