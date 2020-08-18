package nPr_nCr;

import java.util.Arrays;

public class PermTest {
	static int[] aa = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	static int N = aa.length;
	static int R;
	static boolean[] b;
	static int[] num;
	static int result;
	
	public static void main(String[] args) {
		R = 5;			// 5개 중에 3개 선택 -> nPr

		b = new boolean[N];
		num = new int[R];
		
		nPr(0);
		
		System.out.println(result + "개");
	}

	private static void nPr(int cnt) {
		if (cnt == R) {
			result++;
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (b[i]) 
				continue;
			b[i] = true;		// 1 2 3
			num[cnt] =aa[i];
			nPr(cnt + 1);
			b[i] = false;
		}
		
	}

}
