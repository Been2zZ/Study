package ssafy0819.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.plaf.basic.BasicBorders;
public class ChatClient4 {

//	String ip = "127.0.0.1";
	String ip = "192.168.208.40";
	int port = 9875;
	
	public void go() {
		try(Socket s = new Socket(ip, port)) {
			
			
			PrintWriter pw = new PrintWriter(
					new OutputStreamWriter(s.getOutputStream()), true);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			BufferedReader brs = new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.println("이름을 입력하세요.");
			String name = br.readLine();
			String msg = "";
			while((msg = br.readLine()) != null) {
//				System.out.println(msg);
				pw.println("[" + name + "]" + msg);	// client -> server
				Thread t = new Thread(()->{
					try {
						System.out.println(brs.readLine());			// socket ->
					} catch (IOException e) {
						System.out.println(e);
					}
				});
				t.start();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	public static void main(String[] args) {
		ChatClient4 client = new ChatClient4();
		client.go();
	}

}
