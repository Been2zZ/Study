package ssafy0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Miro {
	public static int T;
	public static int N;
	public static int x;
	public static int y;
	public static int num;
	public static int count;
	public static int Answer_x = -1;
	public static int Answer_y = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine().trim());
		// 테스트 케이스 수
		T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			// 배열 크기
			N = Integer.parseInt(st.nextToken());
			// 출발점 좌표
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			// 점퍼의 개수
			num = Integer.parseInt(st.nextToken());
			
			// miro matrix 2D
			int[][] miro = new int[N + 1][N + 1];
			
			st = new StringTokenizer(br.readLine().trim());
			
			// jumper init
			for (int i = 0; i < num; i++) {
				int x_jumper = Integer.parseInt(st.nextToken());
				int y_jumper = Integer.parseInt(st.nextToken());
				miro[x_jumper][y_jumper] = -1;
			}
			
			// 이동지시 개수
			st = new StringTokenizer(br.readLine().trim());
			count = Integer.parseInt(st.nextToken());
			
			// 이동지시(방향, 이동칸수)
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < count; i++) {
				int dir = Integer.parseInt(st.nextToken());
				int moveCount = Integer.parseInt(st.nextToken());
//				goMove(miro, dir, moveCount);
				goMove2(miro, dir, moveCount);
			}
		
			System.out.println("#" + t + " " + Answer_x + " " + Answer_y); 
		}
	}

	private static int goMove2(int[][] miro, int dir, int moveCount) {
		/**
		 * 1 : up
		 * 2 : right
		 * 3 : down
		 * 4 : left
		 */
		
		int i = x;
		int j = y;
		
		int count = moveCount;
		
		switch (dir) {
		case 1:				// up
			for (int k = 0; k < moveCount; k++) {
				if (i > 0 && miro[--i][j] == -1) {
					Answer_x = 0;
					Answer_y = 0;
					return 1;
				}
			}
			break;	
		case 2:				// right
			for (int k = 0; k < moveCount; k++) {
				if (j < miro.length - 1 && miro[i][++j] == -1) {
					Answer_x = 0;
					Answer_y = 0;
					return 1;
				}
			}
			break;	
		case 3:				// down
			for (int k = 0; k < moveCount; k++) {
				if (i < miro.length - 1 && miro[++i][j] == -1) {
					Answer_x = 0;
					Answer_y = 0;
					return 1;
				}
			}
			break;	
		case 4:				// left
			for (int k = 0; k < moveCount; k++) {
				if (j > 0 && miro[i][--j] == -1) {
					Answer_x = 0;
					Answer_y = 0;
					return 1;
				}
			}
			break;	
		}
		x = i;
		y = j;
		
		if (i >= miro.length - 1
				|| j >= miro.length - 1
						|| i < 1 || j < 1) {
				Answer_x = 0;
				Answer_y = 0;
			} else {
				Answer_x = x;
				Answer_y = y;
			}
		
		return 0;
	}

	private static void goMove(int[][] miro, int dir, int moveCount) {
		/**
		 * 1 : up
		 * 2 : right
		 * 3 : down
		 * 4 : left
		 */
		int i = -1, j = -1;
		int xx, yy;
		
		switch (dir) {
		case 1:				// up
			xx = x;
			for (int k = 0; k < moveCount; k++) {
				if (miro[--xx][y] == -1) {
					Answer_x = 0;
					Answer_y = 0;
				}
			}
			i = x - moveCount;
			j = y;
			break;	
		case 2:				// right
			yy = y;
			for (int k = 0; k < moveCount; k++) {
				if (miro[x][++yy] == -1) {
					Answer_x = 0;
					Answer_y = 0;
				}
			}
			i = x;
			j = y + moveCount;
			break;
		case 3:				// down
			xx = x;
			for (int k = 0; k < moveCount; k++) {
				if (miro[++xx][y] == -1) {
					Answer_x = 0;
					Answer_y = 0;
				}
			}
			i = x + moveCount;
			j = y;
			break;
		case 4:				// left
			yy = y;
			for (int k = 0; k < moveCount; k++) {
				if (miro[x][--yy] == -1) {
					Answer_x = 0;
					Answer_y = 0;
				}
			}
			i = x;
			j = y - moveCount;
			break;
		}
		
		x = i;
		y = j;
		
		if (i >= miro.length
			|| j >= miro.length
					|| i < 1 || j < 1) {
			Answer_x = 0;
			Answer_y = 0;
		} else {
			Answer_x = x;
			Answer_y = y;
		}
		
	}

}
