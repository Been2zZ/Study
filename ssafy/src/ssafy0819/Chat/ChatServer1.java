package ssafy0819.Chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer1 {

	String ip = "127.0.0.1";
	int port = 9876;
	
	public void go() {
		try(ServerSocket ss = new ServerSocket(port)) {
			ss.setReuseAddress(true);
			boolean isS = true;
			System.out.println("1. ServerSocket Ready ~~~~~");
			
			while (isS) {
				Socket s = ss.accept();
				System.out.println("2. ServerSocket Contact ~~~~");
				System.out.println(s.getLocalAddress());
				System.out.println(s.getInetAddress());
				BufferedReader br = new BufferedReader(
						new InputStreamReader(s.getInputStream()));
				
				String msg = "";
				while((msg = br.readLine()) != null) {
					System.out.println(msg);
				}
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		ChatServer1 server = new ChatServer1();
		server.go();
	}
}
