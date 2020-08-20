package ssafy0819.com.server;

import  java.io.*;
import  java.net.*;
import  java.util.*;

public class ChatServer{

	Vector				buffer;
	ServerSocket			serverSocket;
	Socket				socket;
	ObjectInputStream	ois;
	ObjectOutputStream   oos;

	public void service(){
		try{
			System.out.println("접속 준비중");
			serverSocket=new ServerSocket(5555);
		}catch(IOException e){
			System.out.println("서비스 준비중에 IOException 이 발생했습니다.");
		}

		while(true){
			try{
				socket=serverSocket.accept();
				System.out.println(socket.getInputStream());

				ois=new ObjectInputStream(socket.getInputStream());
				oos=new ObjectOutputStream(socket.getOutputStream());

				Thread t=new Thread(new ChatServerThread(buffer,ois,oos));
				t.start();
			}catch(IOException e){
				System.out.println("IOException이 발생했습니다.");
			}
		}
	}

	public static void main(String args[]){
		System.out.println("start Server service...");
		ChatServer cs=new ChatServer();
		cs.buffer=new Vector(5,1);
		cs.service();
	}
}

