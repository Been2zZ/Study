package ssafy0819.Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer4 {

	String ip="127.0.0.1";
	//String ip="192.168.214.40";
	int port=9875;
	
	// 쓰레드방 준비
	// server는 thread를 여러개 갖고 있음
	Vector<ChatServer4Thread> rooms = new Vector<>(5, 1);
	
	public void addRoom(ChatServer4Thread r) {
		rooms.add(r);
		System.out.println("현재"+rooms.size() + "이 있습니다.");
	}
	public void removeRoom(ChatServer4Thread r) {
		rooms.remove(r);
	}
	// 중요 모든 쓰레드에 메세지를 보낸다.
	public synchronized void broadcasting(String msg) {
		for (int i = 0; i < rooms.size(); i++) {
			ChatServer4Thread st=rooms.get(i);
			// 해당 쓰레드에 메세지를 보낸다.
			st.sendMessage(msg);
		}
	}
	
	
	public void go() {
		try(ServerSocket ss=new ServerSocket(port)){
			ss.setReuseAddress(true);
			boolean isS = true;
			System.out.println("1. ServerSocket Ready ~~~~~");
			while(isS) {
				Socket s = ss.accept();
				ChatServer4Thread t = new ChatServer4Thread(s, this);
				addRoom(t);
				broadcasting(s.getInetAddress() + "입장!!");
				t.start();
			}
		}catch(IOException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		ChatServer4 server = new ChatServer4();
		server.go();
	}

}
