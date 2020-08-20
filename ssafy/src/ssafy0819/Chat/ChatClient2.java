package ssafy0819.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.plaf.basic.BasicBorders;
public class ChatClient2 {

	String ip = "127.0.0.1";
	int port = 9877;
	
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
		ChatClient2 client = new ChatClient2();
		client.go();
	}

}
