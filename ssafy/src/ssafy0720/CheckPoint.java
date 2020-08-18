package ssafy0720;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		int weight = sc.nextInt();
		
		int result = weight + 100 - length;
		
		System.out.printf("비만수치는 %d 입니다.\n", result);
		
		if(result > 0)
			System.out.println("당신은 비만이군요.");

	}

}
