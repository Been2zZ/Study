package ssafy0814;

import java.util.Scanner;
import java.util.TreeSet;

public class Solution_maximumSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		
		for (int i = 0; i < n; i++) 
			arr[i] = sc.nextInt();
		
		TreeSet<Integer> set = new TreeSet<>();
		
		int cnt = 1;

		for (int i = n; i > 0; i--) {
//			if (cnt > n) 
//				break;
			for (int k = 0; k < n; k++) {
				int sum = 0;
				for (int j = k; j < cnt; j++) 
					sum += arr[j];
				set.add(sum);
			}
			cnt++;
		}
		System.out.println(set.last());
	}


}
