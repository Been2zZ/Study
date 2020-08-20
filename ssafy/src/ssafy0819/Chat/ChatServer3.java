package ssafy0819.Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer3 {

	String ip = "127.0.0.1";
	int port = 9877;
	
	public void go() {
		try(ServerSocket ss = new ServerSocket(port)) {
			ss.setReuseAddress(true);
			boolean isS = true;
			System.out.println("1. ServerSocket Ready ~~~~~");
			
			while (isS) {
				Socket s = ss.accept();
				
				ChatServer3Thread t = new ChatServer3Thread(s);
				t.start();
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		ChatServer3 server = new ChatServer3();
		server.go();
	}
}
