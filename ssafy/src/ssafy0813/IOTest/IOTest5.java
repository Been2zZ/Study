package ssafy0813.IOTest;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class IOTest5 {

	public static void main(String[] args) {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		PrintWriter pw=null;
		try {
			pw=new PrintWriter(
				new FileWriter("aaa.txt",
						false),  // append flag
				         true);  // flush flag
			String msg="";
			while((msg=br.readLine())!=null){
				pw.println(msg);
				//pw.flush();
			}
		} catch (IOException e) {
			
		}finally{
			if(pw!=null){
				pw.close();
			}
		}
	}
}
