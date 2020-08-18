package ssafy0814;

import java.util.Scanner;
import java.util.TreeSet;

public class Solution_D4_4111_무선단속카메라 {
	
	static class Name implements Comparable<Name> {
		String name;

		public Name(String name) {
			super();
			this.name = name;
		}

		@Override
		public int compareTo(Name o) {
			if (this.name.length() - o.name.length() > 0) 
				return 1;
			else if (this.name.length() - o.name.length() < 0) 
				return -1;
			else 
				return this.name.compareTo(o.name);
		}
	}
	
	static int T, N, K;
	static TreeSet<Name> names = new TreeSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			names.clear();
			N = sc.nextInt();
			for (int i = 0; i < N; i++)
				names.add(new Name(sc.next().trim()));
			
			System.out.println("#" + t);
			for (Name name : names)
				System.out.println(name.name);
		}
	}
}
