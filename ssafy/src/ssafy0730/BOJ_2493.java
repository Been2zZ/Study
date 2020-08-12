package ssafy0730;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
	
	public static class Top {
		int x;
		int y;
		
		public Top(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Top> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int h = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if (stack.peek().y >= h) {
					bw.write(stack.peek().x + " ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) 
				bw.write("0 ");
			stack.push(new Top(i, h));
		}
		bw.flush();
		br.close();
		bw.close();
	}


}
