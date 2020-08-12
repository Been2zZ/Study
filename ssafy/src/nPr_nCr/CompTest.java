package nPr_nCr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class CompTest {
	
	// 두개가 따로 들어올 때
	static class PPC implements Comparator<PP> {

		@Override
		public int compare(PP p1, PP p2) {
			double r1 = Math.sqrt(p1.r * p1.r + p1.c * p1.c);
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
	
	static class PP {
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
	}
	
	public static void main(String[] args) {
		ArrayList<PP> ps = new ArrayList<>();
		ps.add(new PP(1, 3));
		ps.add(new PP(2, 3));
		ps.add(new PP(2, -3));
		ps.add(new PP(1, 4));
		
		System.out.println("--------------------------");
		for (PP pp : ps) 
			System.out.println(pp);
		
//		ps.sort(new PPC());
		
		Collections.sort(ps, new PPC());
		
		System.out.println("--------------------------");
		for (PP pp : ps) 
			System.out.println(pp);
		
	}

}
