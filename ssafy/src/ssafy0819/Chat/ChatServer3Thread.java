package ssafy0819.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatServer3Thread extends Thread {

	Socket s;
	BufferedReader br;
	PrintWriter pw;
	
	public ChatServer3Thread(Socket s) {
		super();
		this.s = s;				// socket in
		System.out.println("2. ServerSocket Contact ~~~~");
		System.out.println(s.getLocalAddress());
		System.out.println(s.getInetAddress());
		System.out.println(s.getPort());
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void run() {
		try {
			String msg = "";
			while ((msg = br.readLine()) != null) {
				pw.println("[s]" + msg);
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (pw != null) {
				pw.close();
			}
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}
}
