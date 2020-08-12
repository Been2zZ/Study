package ssafy0722;

import java.util.Scanner;

public class Salt {
	public static int T;
	public static int N;
	public static int num;
	public static int x;
	public static int y;
	public static int dir;
	public static int Answer;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		int[][] arr;
		
		for (int t = 1; t <= T; t++) {
			
			N = sc.nextInt();		// 연못 크기
			num = sc.nextInt();		// 소금쟁이 수
			
			arr = new int[N][N];
			
			int check = 0;			//  같은 자리를 뛴 소금쟁이 존재 유무
			
			for (int n = 1; n <= num; n++) {
				x = sc.nextInt();
				y = sc.nextInt();
				dir = sc.nextInt();
				
				Answer = n;
				
				if (arr[x][y] == 1) {
					System.out.println("#" + t + " " + Answer);
					break;
				}
				
				switch (dir) {
				case 1:			// down
					int p = x;
					for (int j = 3; j > 0; j--) {
						p += j;
						
						if (p >= N) break;
						
						if (arr[p][y] == 1) {
							System.out.println("#" + t + " " + Answer);
							check = 1;
							break;
						} else {
							arr[p][y] = 1;
						}
					}
					break;

				case 2:			// right
					int q = y;
					for (int j = 3; j > 0; j--) {
						q += j;
						
						if (q >= N) break;
						
						if (arr[x][q] == 1) {
							System.out.println("#" + t + " " + Answer);
							check = 1;
							break;
						} else {
							arr[x][q] = 1;
						}
					}
					break;
				}
				
			}
			if (check == 0)
				 System.out.println("#" + t + " " + check);
		}
	}

}
