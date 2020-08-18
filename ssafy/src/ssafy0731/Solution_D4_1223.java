package ssafy0731;

import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1223 {
	static int T = 10;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			
			String inOrder = sc.next();
			String postOrder = "";
			
			Stack<Character> OP = new Stack<>();
			Stack<Integer> SUM = new Stack<>();
			
			// in order -> post order
			for (int i = 0; i < N; i++) {
				char temp = inOrder.charAt(i);
				if (temp - '0' >= 0 && temp - '0' < 10)	{		// 숫자 
					postOrder += temp;
				} else {										// 연산자
					while (!OP.empty() && (int)OP.peek() <= (int)temp)
						postOrder += OP.pop();
					OP.push(temp);
				}
			}
			while (!OP.isEmpty()) 
				postOrder += OP.pop();
			
			// calculation
			for (int i = 0; i < N; i++) {
				char temp = postOrder.charAt(i);
				if (temp - '0' >= 0 
						&& temp - '0' < 10) {	// 숫자 입력
					SUM.push(temp - '0');
				} else {
					switch (temp) {
					case '+':
						int sum = 0;
						for (int j = 0; j < 2; j++)	sum += SUM.pop();
						SUM.push(sum);
						break;
					case '*':
						int mul = 1;
						for (int j = 0; j < 2; j++)	mul *= SUM.pop();
						SUM.push(mul);
						break;
					}
				}
			}
			System.out.println("#" + t + " " + SUM.pop());
		}
	}

}
