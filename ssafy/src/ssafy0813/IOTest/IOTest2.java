package ssafy0813.IOTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOTest2 {

	public static void main(String[] args) {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		String msg="";
		// 
		try {
			while(( msg=br.readLine())!=null){
				System.out.println(msg);
			}
		}catch (IOException e) {
			System.out.println(e);
		}catch (Exception e) {
			System.out.println(e);
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					
				}
			}
		}
	}

}
