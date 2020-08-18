package ssafy0813.IOTest;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class IOTest3 {

	public static void main(String[] args) {
		
		PrintWriter pw=null;
		try {
			pw=new PrintWriter(
				new FileWriter("student.xml",
						false),  // append flag
				         true);  // flush flag
			//eXtensible Markup Language
			String msg="<students>";
			msg+="<student>";
			msg+="<name>";
			msg+="홍길동";
			msg+="</name>";
			msg+="<age>";
			msg+="16";
			msg+="</age>";
			msg+="<tel>";
			msg+="010-1234-123";
			msg+="</tel>";
			msg+="</student>";
			msg+="<student>";
			msg+="<name>";
			msg+="장길산";
			msg+="</name>";
			msg+="<age>";
			msg+="34";
			msg+="</age>";
			msg+="<tel>";
			msg+="010-1234-124";
			msg+="</tel>";
			msg+="</student>";
			msg+="</students>";
			pw.println(msg);
//			System.out.println(msg);
			
		} catch (IOException e) {
			
		}finally{
			if(pw!=null){
				pw.close();
			}
		}
	}
}
