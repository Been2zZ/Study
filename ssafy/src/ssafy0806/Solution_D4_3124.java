package ssafy0806;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * 
 * @ClassName Solution_D4_3124.java
 * @author  JEONG SUBEEN
 *
 * @since 2020. 8. 6.
 * @version 1.0
 * 
 * @title -> 최소 스패닝 트리
 */
public class Solution_D4_3124 {
	static int[] parent;
	static ArrayList<Edge> list;
	
	public static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		int w;
		
		public Edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.w < o.w)
	            return -1;
	        else if(this.w == o.w)
	            return 0;
	        else
	            return 1;
	    }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for (int t = 1; t <= T; t++) {
			int Answer = 0;
			int V = sc.nextInt();	// 정점의 개수
			int E = sc.nextInt();	// 간선의 개수
			
			parent = new int[V + 1];
			for (int i = 1; i <= V; i++)
				parent[i] = i;
			
			list = new ArrayList<>();
			
			for (int i = 0; i < E; i++) 
				list.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			
			Collections.sort(list);
			
			for (int i = 0; i < list.size(); i++) {
				Edge edge = list.get(i);
				if (find(edge.v1) != find(edge.v2)) {
					Answer += edge.w;
					union(edge.v1, edge.v2);
				}
			}
			System.out.println("#" + t + " " + Answer);
		}

	}
	
	public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if(x != y)
            parent[y] = x;
    }
	
    public static int find(int x) {
		if(parent[x] == x)
			return x;
        
		return	parent[x] = find(parent[x]);
    }

}
