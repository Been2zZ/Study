package ssafy0721;

import java.util.Scanner;

public class DigitTest1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int inputNum = -1;
		int count[] = new int[10];
		
		while(true) {
			inputNum = sc.nextInt();
			
			if(inputNum == 0)
				break;
			
			count[inputNum / 10]++;			
		}
		
		for(int i = 0; i < count.length; i++)
			if(count[i] != 0)
				System.out.printf("%d : %d개\n", i, count[i]);
		
	}
}
