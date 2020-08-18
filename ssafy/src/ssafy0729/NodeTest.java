package ssafy0729;

import java.util.Arrays;
import java.util.Comparator;

public class NodeTest {
	
	public static class PointsComp implements Comparator<Points> {

		@Override
		public int compare(Points p1, Points p2) {
			double r1 = Math.sqrt(p1.r * p1.r + p1.c * p1.c);
			double r2 = Math.sqrt(p2.r * p2.r + p2.c * p2.c);
			
			if (r1 - r2 > 0)
				return 1;
			else if (r1 - r2 < 0)
				return -1;
			else return 0;
		}
		
	}
	
	public static class Points {
		int r;
		int c;
		
		public Points(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + "]";
		}
		
		private void compareTo() {
			
		}
	}

	public static void main(String[] args) {
		Points[] ps = new Points[5];
		
		ps[0] = new Points(1, 2);
		ps[1] = new Points(-4, 2);
		ps[2] = new Points(-1, 2);
		ps[3] = new Points(1, 3);
		ps[4] = new Points(2, 3);
		
		for (int i = 0; i < ps.length; i++) 
			System.out.println(ps[i]);
		
		System.out.println("------------");
		
		for (Points p : ps) 
			System.out.println(p);

		System.out.println("------------");
		
		Arrays.sort(ps, new PointsComp());
		for (int i = 0; i < ps.length; i++) 
			System.out.println(ps[i]);
		
	}

}
