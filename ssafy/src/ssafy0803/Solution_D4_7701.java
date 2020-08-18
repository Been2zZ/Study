package ssafy0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution_D4_7701 {
	/* 염라대왕의 이름 정렬 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			// TreeSet (BST)
			TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() - o2.length() == 0)		// 길이가 같은 경우
						return o1.compareTo(o2);			// -> 사전순
					else									// 길이가 다른 경우 
						return o1.length() - o2.length();	// -> 길이순
				}
			});
			
			//정렬되며 삽입
			for (int i = 0; i < N; i++)
				treeSet.add(br.readLine().trim());
			
			// print
			System.out.println("#" + t);
			for (String string : treeSet)
				System.out.println(string);
		}
	}
}
