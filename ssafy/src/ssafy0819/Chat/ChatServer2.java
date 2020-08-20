package ssafy0819.Chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer2 {

	String ip = "127.0.0.1";
	int port = 9877;
	
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
				// socket에서 메세지 읽어서
				BufferedReader br = new BufferedReader(
						new InputStreamReader(s.getInputStream()));
				// socket에서 메세지 보내기
				try(PrintWriter pw = new PrintWriter(
						new OutputStreamWriter(s.getOutputStream()), true)) {
					String msg = "";
					while((msg = br.readLine()) != null) {
//						System.out.println(msg);
						pw.println("[s]" + msg);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		ChatServer2 server = new ChatServer2();
		server.go();
	}
}
