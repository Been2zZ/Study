package ssafy0731;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DuDu_BFS {
	static int N;
	static int[][] map;
	static int[][] b;		// map과 동일한 크기 -> 지나갔는지 검사??
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		b = new int[N][N];
	
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
				
		int cnt = 0;
		for (int i = 0; i < N; i++) 
			
			for (int j = 0; j < N; j++) 
				if (map[i][j] == 1 && b[i][j] == 0) 
					bfs(i, j, ++cnt + 1);
		
		System.out.println(cnt);				// 두더지굴 개수
        for (int i = 2; i <= cnt+1; i++) {		// 2, 3, 4
            int count=0;
            for (int j = 0; j < N; j++) 
                for (int k = 0; k < N; k++) 
                    if(b[j][k]==i)   			//2,3,4 굴
                        count++;      			//의 개수
            System.out.println(count);
        }
	}

	// 우좌 상하
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	private static void bfs(int r, int c, int k) {
		Queue<int []> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		b[r][c]= k;							// 'k'group
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cr = curr[0];
			int cc = curr[1];
			for (int d = 0; d < 4; d++) {	// 4 : 네 방향
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (!check(nr, nc)) continue;
				
				if (map[nr][nc] == 1 && b[nr][nc] == 0) {
					b[nr][nc] = k;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		
	}
	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		else	return false;
	}

}
