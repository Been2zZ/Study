package ssafy0729;

import java.util.Scanner;

public class Solution_D4_1210 {
	static int T = 10, W = 100;
	static int[][] map;
	static int Answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= T; test_case++) {
			map = new int[W][W];
			
			int t = sc.nextInt();
			
			for (int i = 0; i < W; i++)
				for (int j = 0; j < W; j++)
					map[i][j] = sc.nextInt();
			
			int key = 0;
			for(int i = 0; i < W; i++) 
				if(map[W-1][i] == 2) 
					key = i;
			
			Answer = sol(map, W - 1, key, 0);
			
			System.out.println("#" + t + " " + Answer);
		}
	}
	private static int sol(int[][] map, int i, int j, int dir) {
		
		if(j > 0 && map[i][j-1] == 1 && dir == -1) {
			if(map[i-1][j-1] == 1)
				return sol(map, i-1, j-1, 0);
			else
				return sol(map, i, j-1, -1);
		} else if(j < W - 1 && map[i][j+1] == 1 && dir == 1) {
			if(map[i-1][j+1] == 1)
				return sol(map, i-1, j+1, 0);
			else
				return sol(map, i, j+1, 1);
		} else if(i > 0 && map[i-1][j] == 1 && dir == 0) {
			if(j > 0 && map[i][j-1] == 1)
				return sol(map, i, j-1, -1);
			else if(j < W-1 && map[i][j+1] == 1)
				return sol(map, i, j+1, 1);
			
			if(j > 0 && map[i-1][j-1] == 1)
				return sol(map, i-1, j-1, -1);
			else if(j < W-1 && map[i-1][j+1] == 1)
				return sol(map, i-1, j+1, 1);
			else return sol(map, i-1, j, 0);
		}
		
		return j;
		
	}
}
