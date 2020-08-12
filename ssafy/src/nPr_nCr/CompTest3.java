package nPr_nCr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;

public class CompTest3 {
	
	static class PP implements Comparable<PP> {
		int r;
		int c;
		
		public PP(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "PP [r=" + r + ", c=" + c + "]";
		}

		@Override
		public int compareTo(PP p2) {
			double r1 = Math.sqrt(r * r + c * c);
			double r2 = Math.sqrt(p2.r * p2.r + p2.c * p2.c);
			
			// asc
			if (r1 - r2 > 0)
				return -1;
			else if (r1 - r2 < 0)
				return 1;
			else
				return 0;
		}
	}
	
	public static void main(String[] args) {
//		ArrayList<PP> ps = new ArrayList<>();
		Queue<PP> ps = new PriorityQueue<>();
		
		ps.add(new PP(1, 3));
		ps.add(new PP(2, 3));
		ps.add(new PP(2, -3));
		ps.add(new PP(1, 4));
		
		System.out.println("--------------------------");
		for (PP pp : ps) 
			System.out.println(pp);
		
//		ps.sort(new PPC());
//		Collections.sort(ps, new PPC());
		
		ps.add(new PP(0, 1));
		
		System.out.println("--------------------------");
		for (PP pp : ps) 
			System.out.println(pp);
		
	}

}
