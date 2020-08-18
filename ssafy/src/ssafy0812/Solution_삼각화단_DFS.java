package ssafy0812;

import java.util.HashSet;
import java.util.Scanner;

public class Solution_삼각화단_DFS {
	
	static class Point {
		int a;
		int b;
		int c;
		
		public Point(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
			result = prime * result + c;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			Point other = (Point) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			return true;
		}
		
	}
	
	static int N;
	static HashSet<Point> ts = new HashSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		ts.clear();
		
		dfs(N, 1, 1, 1);
		
		// print 1
		for (Point p : ts)
			System.out.println(p.a + " " + p.b + " " + p.c);
	
		// print 2
//		Iterator<Point> pt = ts.iterator();
//		while(pt.hasNext()) {
//			Point p = pt.next();
//			System.out.println(p.a + " " + p.b + " " + p.c);
//		}
		
		System.out.println(ts.size());
	}
	
	private static void dfs(int n, int i, int j, int k) {
		if (i + j + k == n) {
			if (i + j > k && j + k > i && i + k > j && i <= j && j <= k)
				ts.add(new Point(i, j, k));		//중복안됨
			return;
		}
		dfs(n, i + 1, j, k);
		dfs(n, i, j + 1, k);
		dfs(n, i, j, k + 1);
	}

}
