package ssafy0813.IOTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class IOTest4 {

	public static void main(String[] args) {
		File f=null;
		BufferedReader br=null;
		try {
			f=new File("aaa.txt");
			System.out.println(f.canRead());
			System.out.println(f.getAbsolutePath());
			
			if(f.exists()){
				br=new BufferedReader(new FileReader(f));
				String msg="";
				while((msg=br.readLine())!=null){
					System.out.println(msg);
				}
			}
			
		} catch (IOException e) {
			
		}
	}
}
