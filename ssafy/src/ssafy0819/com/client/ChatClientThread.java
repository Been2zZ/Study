package ssafy0819.com.client;

import    java.io.*;
import    java.util.*;

import ssafy0819.com.Data;

public class ChatClientThread implements Runnable{
	ObjectInputStream  ois;
	ChatClient cc;
	Data d;
	boolean exit=false;

	public ChatClientThread(ObjectInputStream ois,ChatClient cc){
		this.ois=ois;
		this.cc=cc;
	}

	public void run(){
		while(!exit){
			try{
				d=(Data)ois.readObject();
			}catch(Exception e){
				//System.out.println("run methodIOEXception");
			}

			int    state=d.getState();
			String name=d.getName();
			if(state==Data.처음접속){
				Vector userName=d.getUserName();
				cc.userList.removeAll();
				for(int i=0;i<userName.size();i++){
					cc.userList.add((String)userName.get(i));
				}
				cc.userCountLabel.setText("현재"+cc.userList.getItemCount()+"명 접속중");
			}else if(state==Data.접속종료){
				cc.userList.remove(name);
				cc.userCountLabel.setText("현재"+cc.userList.getItemCount()+"명 접속중");
			}
			cc.commText.append("["+name+"]"+d.getMessage()+"\n");
		}
		try{
			ois.close();
		}catch(IOException e){
			System.out.println("ChatClientThread에의 ObjectOutputStream을 close하는 중에"+
					"exception 발생");
		}
	}
}