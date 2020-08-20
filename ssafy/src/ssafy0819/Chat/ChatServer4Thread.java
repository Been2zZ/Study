package ssafy0819.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatServer4Thread extends Thread{

	Socket s;
	BufferedReader br;
	PrintWriter pw;
	ChatServer4 chatServer4;
	
	public ChatServer4Thread(Socket s, ChatServer4 chatServer4) {
		this.s = s;
		this.chatServer4 = chatServer4;
		
		System.out.println("2. ServerSocket Contact ~~~~~");
		System.out.println(s.getLocalAddress());
		System.out.println(s.getInetAddress());
		System.out.println(s.getPort());
		try {
			br=new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			pw=new PrintWriter(
					new OutputStreamWriter(s.getOutputStream()), true);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}


	@Override
	public void run() {
		try {
			String msg = "";
			while((msg = br.readLine()) != null) {
				if(msg.equalsIgnoreCase("quit!!")) {
					this.chatServer4.removeRoom(this);
					this.chatServer4.broadcasting(s.getInetAddress() + "퇴장!!");
					break;
				}
				//pw.println("[S]" + msg);
				this.chatServer4.broadcasting(msg);
				System.out.println(s.getInetAddress() + "" + msg);
			}
		} catch (IOException e) {
			System.out.println(e);
		}finally {
			if(pw != null) {
				pw.close();
			}
			if(s != null) {
				try {
					s.close();
				} catch (IOException e) {
					
				}
			}
		}
	}


	public void sendMessage(String msg) {
		pw.println(msg);
	}
	
}
