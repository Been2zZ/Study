package nPr_nCr;

public class SubSetTest {
	static int[] aa = {1, 2, 3, 4, 5};
	static int N = aa.length;
	static int R;
	static boolean[] b;
	static int[] num;
	static int result;
	
	public static void main(String[] args) {
		R = 3;
		subset(0, 0);
		System.out.println(result + "개");
	}

	private static void subset(int cnt, int sum) {
		
		if (cnt == R) {
			System.out.println(sum);
			return;
		}
		
		subset(cnt + 1, sum + aa[cnt]);		// 포함
		subset(cnt + 1, sum);				// 미포함
		
	}

}
