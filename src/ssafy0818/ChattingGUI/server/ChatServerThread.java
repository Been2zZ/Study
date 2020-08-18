package ssafy0818.ChattingGUI.server;

import   java.io.*;
import   java.util.*;

import ssafy0818.ChattingGUI.Data;

public class ChatServerThread implements Runnable{

	Vector buffer;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Data d;
	boolean exit;
	String name;

	public ChatServerThread(Vector v,ObjectInputStream ois,ObjectOutputStream oos){
		buffer=v;
		this.ois=ois;
		this.oos=oos;
		exit=false;
	}

	public void run(){
		while(!exit){
			try{
				d=(Data)ois.readObject();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Exception이 발생");
			}

			int state=d.getState();
			if(state==Data.접속종료){

				d.setMessage("님이 종료하셨습니다.");
				name=d.getName();
				broadCasting();
				synchronized (buffer) {
					for(int i=0;i<buffer.size();i++){
						if(((Data)buffer.get(i)).getName().equals(name)){
							buffer.remove(i);
						}
					}
				}

				try{
					ois.close();
					oos.close();
				}catch(Exception x){}
				exit=true;

			}else if(state==Data.처음접속){
				Vector userName=new Vector(5,1);
				d.setOOS(oos);
				buffer.add(d);
				for(int i=0;i<buffer.size();i++){
					userName.add(((Data)buffer.get(i)).getName());
				}
				d.setUserName(userName);
				System.out.println("broadCasting 시작");
				broadCasting();
			}else{
				broadCasting();
			}
		}
	}

	public synchronized void broadCasting(){
		for(int i=0;i<buffer.size();i++){
			try{
				((Data)buffer.elementAt(i)).getOOS().writeObject(d);
			}catch(IOException e){
				System.out.println("broadCasting method에서 IOException 이 발생하였습니다.");
				e.printStackTrace();
			}
		}
	}
}//class



