package nPr_nCr;

import java.util.Arrays;

public class CombiTest {
	/**
	 * 중복 X
	 */
	static int[] aa = {1, 2, 3, 4, 5};
	static int N = aa.length;
	static int R;
	static boolean[] b;
	static int[] num;
	static int result;
	
	public static void main(String[] args) {
		R = 3;			// 5개 중에 3개 선택 -> nPr

		b = new boolean[N];
		num = new int[R];
		
		nCr(0, 0);
		
		System.out.println(result + "개");
	}

	private static void nCr(int start, int cnt) {
		if (cnt == R) {
			result++;
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for (int i = start; i < N; i++) {
			num[cnt] = aa[i];
			nCr(i + 1, cnt + 1);
		}
	}

}
