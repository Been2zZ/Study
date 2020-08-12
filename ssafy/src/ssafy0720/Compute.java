package ssafy0720;

import java.util.Scanner;

public class Compute {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int mul = a * b;
		int div = a / b;
		
		System.out.println("곱 = " + mul);
		System.out.println("몫 = " + div);

	}

}
