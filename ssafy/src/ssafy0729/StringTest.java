package ssafy0729;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		String a = "hello";
		String b = "hello";
		String c = new String("hello");
		
		System.out.println(a == b);				// o
		System.out.println(a == c);				// x
		System.out.println(a.equals(b));		// o
		System.out.println(a.equals(c));		// o
		
		System.out.println("------------");
		
		char[] ac = a.toCharArray();
		
		for (int i = 0; i < ac.length; i++) 
			System.out.printf("%c", ac[i]);
		System.out.println();
		System.out.println(new String(ac));
		System.out.println(String.copyValueOf(ac));
		
		System.out.println("------------");
		
		char cc = a.charAt(1);
		System.out.println(cc);
		
		int aa = 13;
		Integer ai = aa;
		int bb = ai;
		System.out.println(bb);
		
		System.out.println("------------");
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toBinaryString(235));
		System.out.println(Integer.toOctalString(235));
		System.out.println(Integer.toHexString(235));
		System.out.println(Integer.parseInt("111", 2));		// 111 이진수로
		
		System.out.println("------------");
		
		System.out.println(Character.isDigit('5'));
		
		System.out.println("------------");
		
		int ab = 0b111;
		int ad = 0x111;
		System.out.println(ab);
		System.out.println(ad);
		
		System.out.println("------------");
		
		System.out.println(a.contains("el"));			// 존재여부
		System.out.println(a.indexOf("el"));
		
		System.out.println("------------");
		
		String string = "13 123 1231 1235 43";
		String[] ats = string.split(" ");
		
		for (String string2 : ats)
			System.out.println(string2);
		
		System.out.println("------------");
		
		System.out.println(Math.abs(-45));
		System.out.println(Math.round(3456.752));
		
		double d = 234.567345243223;
		System.out.printf("%.2f", d);
		
	}

}
