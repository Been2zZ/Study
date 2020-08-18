package ssafy0731;

import java.io.*;

public class Solution_D4_8659 {
	static int T;
	static int K;			// % 연산자 수행 회수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			long A = 0, B = 0;
			K = Integer.parseInt(br.readLine());
		
			int index = 1;
			boolean chk = false;
			
			while (true) {
				index++;
				for (int i = 0; i <= index; i++) {
					if (GCD(index, i, 0) == K) {
						A = index;
						B = i;
						chk = true;
						break;
					}
				}
				if (chk)	break;
			}
			System.out.println("#" + t + " " + A + " " + B);
		}
		
		
		
	}
	private static int GCD(int a, int b, int count) {
		if (b == 0)	return count;
		else	return GCD(b, a%b, count + 1);
	}

}
