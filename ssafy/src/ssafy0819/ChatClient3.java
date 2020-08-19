package ssafy0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.plaf.basic.BasicBorders;
public class ChatClient3 {

//	String ip = "127.0.0.1";
	String ip = "192.168.214.40";
	int port = 9876;
	
	public void go() {
		try(Socket s = new Socket(ip, port)) {
			
			
			PrintWriter pw = new PrintWriter(
					new OutputStreamWriter(s.getOutputStream()), true);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			BufferedReader brs = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			String msg = "";
			while((msg = br.readLine()) != null) {
//				System.out.println(msg);
				pw.println(msg);	// client -> server
//				pw.flush();     	// -> new PrintWriter( ~~ , true) "true" 해주면 flush() 안해줘도됌
				System.out.println(brs.readLine());			// socket ->
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	public static void main(String[] args) {
		ChatClient3 client = new ChatClient3();
		client.go();
	}

}
