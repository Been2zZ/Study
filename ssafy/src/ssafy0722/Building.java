package ssafy0722;

import java.util.Scanner;

public class Building {
	public static int T;
	public static int N;
	public static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N =sc.nextInt();
			
			char[][] map = new char[N][N];
			
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < N; j++) 
					map[i][j] = sc.next().charAt(0);
			
			Answer = calSol(map);
			
			System.out.println("#" + t + " " + Answer); 
		}
	}

	private static int calSol(char[][] map) {
		int floor = 0;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 'B') {
					floor = searchAreaG(map, i, j);
					if (floor != 2) 
						floor = calFloorB(map, i, j);
				}
				if (floor > max) max = floor;
			}
		}
		
		return max;
	}
	
	private static int searchAreaG(char[][] map, int i, int j) {
		int result = 0;
		
		for (int p = i - 1; p <= i + 1; p++) {
			if (p < 0 || p >= map.length)	break;
			for (int q = j - 1; q <= j + 1; q++) {
				if (q < 0 || q >= map.length)	break;
				
				if (map[p][q] == 'G') 
					result = 2;
			}	
		}
		return result;
	}
	private static int calFloorB(char[][] map, int i, int j) {
		int sum = 0;
		
		for (int p = 0; p < map.length; p++)
			if (map[p][j] == 'B')	sum++;
		for (int q = 0; q < map.length; q++)
			if (map[i][q] == 'B')	sum++;

		return sum - 1;
	}

}
