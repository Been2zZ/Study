package ssafy0819.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
public class ChatClient1 {

	String ip = "127.0.0.1";
	int port = 9876;
	
	public void go() {
		try(Socket s = new Socket(ip, port)) {
			
			
			PrintWriter pw = new PrintWriter(
					new OutputStreamWriter(s.getOutputStream()), true);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			
			String msg = "";
			while((msg = br.readLine()) != null) {
//				System.out.println(msg);
				pw.println(msg);	// client -> server
//				pw.flush();     // -> new PrintWriter( ~~ , true) "true" 해주면 flush() 안해줘도됌
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	public static void main(String[] args) {
		ChatClient1 client = new ChatClient1();
		client.go();
	}

}
