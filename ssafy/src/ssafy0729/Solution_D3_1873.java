package ssafy0729;

import java.util.Scanner;

public class Solution_D3_1873 {
	static int T;
	static int H, W;
	static char[][] map;
	static int N;
	static String Input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			H = sc.nextInt();
			W = sc.nextInt();
			
			map = new char[H][W];
			
			int src = -1, dest = -1;
			char dir = ' ';
			
			/**
			 * dir : awsd
			 */
			
			for (int i = 0; i < H; i++) {
				String str = sc.next().trim();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					
					switch (map[i][j]) {
					case '^':
						dir = 'w';
						src = i;
						dest = j;
						break;
					case 'v':
						dir = 's';
						src = i;
						dest = j;
						break;
					case '<':
						dir = 'a';
						src = i;
						dest = j;
						break;
					case '>': 
						dir = 'd';
						src = i;
						dest = j;
						break;
					default:
						break;
					}
				}
			}
			
			N = sc.nextInt();
			
			Input = sc.next().trim();
			
			/**
			 * . : 평지(전차 진입 가능)
			 * * : 벽돌로 만들어진 벽
			 * # : 강철로 만들어진 벽
			 * - : 물(전차는 들어갈 수 없다.)
			 * ^ : 위쪽을 바라보는 전차(아래는 평지이다.)
			 * v : 아래쪽을 바라보는 전차(아래는 평지이다.)
			 * < : 왼쪽을 바라보는 전차(아래는 평지이다.)
			 * > : 오른쪽을 바라보는 전차(아래는 평지이다.)
			 */
		
			for (int i = 0; i < N; i++) {
				switch (Input.charAt(i)) {
				case 'U':
					dir = 'w';
					map[src][dest] = '^';
					if (src > 0 && map[src-1][dest] == '.') {
						map[src][dest] = '.';
						map[src-1][dest] = '^';
						src -= 1;
					}
					break;
				case 'D':
					dir = 's';
					map[src][dest] = 'v';
					if (src < H - 1 && map[src+1][dest] == '.') {
						map[src][dest] = '.';
						map[src+1][dest] = 'v';
						src += 1;
					}
					break;
				case 'L':
					dir = 'a';
					map[src][dest] = '<';
					if (dest > 0 && map[src][dest-1] == '.') {
						map[src][dest] = '.';
						map[src][dest-1] = '<';
						dest -= 1;
					}
					break;
				case 'R':
					dir = 'd';
					map[src][dest] = '>';
					if (dest < W - 1 && map[src][dest+1] == '.') {
						map[src][dest] = '.';
						map[src][dest+1] = '>';
						dest += 1;
					}
					break;
				case 'S':
					int s = src;
					int d = dest;
					if (dir == 'w') {
						while (s > 0) {
							if (map[s-1][dest] == '#') 
								break;
							if (map[s-1][dest] == '*') {
								map[s-1][dest] = '.';
								break;
							}
							if (map[s-1][dest] != '*') 
								s--;
						}
					} else if (dir == 's') {
						while (s < H - 1) {
							if (map[s+1][dest] == '#') 
								break;
							if (map[s+1][dest] == '*') {
								map[s+1][dest] = '.';
								break;
							}
							if (map[s+1][dest] != '*') 
								s++;
						}
					} else if (dir == 'a') {
						while (d > 0) {
							if (map[src][d-1] == '#')
								break;
							if (map[src][d-1] == '*') {
								map[src][d-1] = '.';
								break;
							}
							if (map[src][d-1] != '*') 
								d--;
						}
					} else if (dir == 'd') {
						while (d < W - 1 ) {
							if (map[src][d+1] == '#')
								break;
							if (map[src][d+1] == '*') {
								map[src][d+1] = '.';
								break;
							}
							if (map[src][d+1] != '*') 
								d++;
						}
					}
					break;
				default:
					break;
				}
			}
			
			/**
			 * U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
			 * D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
			 * L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
			 * R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
			 * S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
			 */
			System.out.print("#" + test_case + " ");
			printMap(map);
		}
			
	}
	private static void printMap(char[][] map) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}

}
