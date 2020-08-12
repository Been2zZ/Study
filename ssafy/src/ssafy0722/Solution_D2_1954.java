package ssafy0722;

public class Solution_D2_1954 {
	static int T;
	
	public static void main(String[] args) {
		
		int N = 5;
		int count = 1;

		int[][] arr = new int[N][N];
		
		int chk = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (chk == 0) {
				for (int j = 0; j < arr.length; j++) {
					chk = 1;
					arr[i][j] = count++;
				}
			}
			if (chk == 1) {
				for (int j = 0; j < arr.length; j++) {
					chk = 2;
					arr[j][arr.length - 1 - i] = count++;
				}
			}
			if (chk == 2) {
				for (int j = arr.length - 1; j >= 0; j--) {
					chk = 3;
					arr[arr.length - 1 - i][j] = count++;
				}
			}
			if (chk == 3) {
				for (int j = arr.length - 1; j >= 0; j--) {
					chk = 0;
					arr[j][i] = count++;
				}
			}
		}
		
		
		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i][j] +"  ");
			}
			System.out.println();
		}
		
		
	}

}

