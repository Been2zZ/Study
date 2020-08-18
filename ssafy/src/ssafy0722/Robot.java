package ssafy0722;

import java.util.Scanner;

public class Robot {
	public static int T;
	public static int N;
	public static int Answer;
	
	public static void main(String[] args){
		
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
		/**
		 * A : 오른쪽 이동
		 * B : 좌, 우 이동 
		 * C : 상, 하, 좌, 우 이동
		 */
		
		int count = 0;
		int l, r, u, d;
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				r = j + 1;	l = j - 1;
				u = i + 1;	d = i - 1;
				switch(map[i][j]) {
					case 'C':
						while (u < map.length)
							if (map[u++][j] == 'S')
								count++;
							else break;
						while (d >= 0)
							if (map[d--][j] == 'S')
								count++;
							else break;
					case 'B':
						while (l >= 0)
							if (map[i][l--] == 'S')
								count++;
							else break;
					case 'A':
						while (r < map.length)
							if (map[i][r++] == 'S')
								count++;
							else break;
						break;
				}
			}
		}
		
		return count;
	}

}
