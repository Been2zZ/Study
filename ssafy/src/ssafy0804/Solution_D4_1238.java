package ssafy0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1238 {
	static int T = 10;
	static int MaxN = 100;
	static int N, src, Answer;
	static int[][] G;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int t = 1; t <= T; t++) {
			Answer = 0;
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			src = Integer.parseInt(st.nextToken());
			
			G = new int[MaxN + 1][MaxN + 1];
			visited = new int[MaxN + 1];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				G[from][to] = 1;
			}
			
			Queue<Node> q = new LinkedList<>();
			ArrayList<Node> list = new ArrayList<>();
			
			visited[src] = 1;
			q.add(new Node(src, 1));
			list.add(new Node(src, 1));
			
			int maxDepth = 1;
			
			while (!q.isEmpty()) {
				Node n = q.poll();
				for (int i = 1; i <= MaxN; i++) {
					if (G[n.vertex][i] == 1 && visited[i] == 0) {
						visited[i] = 1;
						q.add(new Node(i, n.depth + 1));
						list.add(new Node(i, n.depth + 1));
					}
				}
				maxDepth = n.depth;
			}
			
			for (int i = 0; i < list.size(); i++) 
				if (list.get(i).depth == maxDepth) 
					Answer = Math.max(Answer, list.get(i).vertex);
			
			System.out.println("#" + t + " " + Answer);
		}
	}

	public static class Node {
		int vertex;
		int depth;
		
		public Node(int vertex, int depth) {
			this.vertex = vertex;
			this.depth = depth;
		}
	}
}
