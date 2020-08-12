package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author JEONG SUBEEN
 *
 * @title -> 연구소 3
 */
public class BOJ_17142 {
	static int N, M;
	static int[][] map;
	static int[][] b;
	static int count;
	static int[] num;
	static int c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();		// 연구소의 크기
		M = sc.nextInt();		// 바이러스 개수
		
		/**
		 * 0 : 빈 칸
		 * 1 : 벽
		 * 2 : 바이러스 놓을 수 있는 위치
		 */
		
		map = new int[N][N];
		b = new int[N][N];
		num = new int[M];
		
		ArrayList<Virus> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				
				if (map[i][j] == 2) 
					list.add(new Virus(i, j));
			}
		}
		
		nCr(0, 0, list);
		
//		System.out.println(c);				// 두더지굴 개수
        for (int i = 0; i < c; i++) {		
            count=0;
            for (int j = 0; j < N; j++) 
                for (int k = 0; k < N; k++) 
                    if(b[j][k]==i)   			//2,3,4 굴
                        count++;      			//의 개수
            System.out.println(count);
        }
	}
	
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	private static void nCr(int start, int cnt, ArrayList<Virus> list) {
		if (cnt == M) {
			int c = 0;
			for (int i = 0; i < num.length; i++) {
				int x = list.get(i).x;
				int y = list.get(i).y;
				
				dfs(x, y, ++c + 1);
			}
			
			return;
		}
		
		for (int i = start; i < N; i++) {
			num[cnt] = i;
			nCr(i + 1, cnt + 1, list);
		}
	}
	
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
				
				if (map[nr][nc] == 0 && b[nr][nc] == 0) {
					b[nr][nc] = k;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		
	}
	
	
	private static void dfs(int r, int c, int cnt) {
		map[r][c] = cnt;					// 2단지, 3단지...
		
		for (int d = 0; d < 4; d++) {		// 4 : 4방향
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (!check(nr, nc)) continue;	// 상하좌우 배열 경계 외부 (Index Out)
			
			if (map[nr][nc] == 1) {
				count = cnt;
				dfs(nr, nc, cnt + 1);
			}
		}
	}
	
	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		else	
			return false;
	}
	
	public static class Virus {
		int x;
		int y;
		
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
