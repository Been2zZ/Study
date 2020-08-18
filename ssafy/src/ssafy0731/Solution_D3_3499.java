package ssafy0731;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_3499 {
	static int T;
	static int N;
	static Queue<String> deck1, deck2;
	static Queue<String> DECK;
	static String[] Anwser;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			N = sc.nextInt();
			
			DECK = new LinkedList<>();
			deck1 = new LinkedList<>();
			deck2 = new LinkedList<>();
			
			Anwser = new String[N];
			
			for (int i = 0; i < N - (N / 2); i++)
				deck1.add(sc.next());
			
			for (int i = 0; i < N / 2; i++) 
				deck2.add(sc.next());
			
			int count = 0;
			
			while(count < N) {
				if (!deck1.isEmpty()) 
					Anwser[count++] = deck1.poll();
				if (!deck2.isEmpty()) 
					Anwser[count++] = deck2.poll();
			}
			System.out.print("#" + test_case);
			for (String a : Anwser) 	System.out.print(" " + a);
			System.out.println();
		}
	}

}
