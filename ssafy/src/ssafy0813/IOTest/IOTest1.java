package ssafy0813.IOTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class IOTest1 {

	public static void main(String[] args) {
		
		try(BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in))){
			String msg="";
			while((msg=br.readLine())!=null){
				System.out.println(msg);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
