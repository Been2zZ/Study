package ssafy0818.ChattingGUI;

import java.io.*;
import java.util.*;

public class Data implements Serializable{
 
   private String message; // client의 message를 저장하는 변수
   private String name;    // client의 user name(firstGUId의 ID)를 저장하는 변수
   private int state;      // client의 상태를 저장하는 변수
  
   
   private transient ObjectOutputStream oos;
   //client가 처음접속할때 접속되어있는 user의 이름을 받아올때 사용할 변수
   private Vector userName;

   public static final int 처음접속 = 0;
   public static final int 접속종료 = -1;
   public static final int 대화중 = 1;

   public Data(String name,String message,int state,ObjectOutputStream o){
     this.name=name;
	 this.message=message;
	 this.state=state;
	 this.oos=oos;
	 }

   public Data(String name,String message,int state){
     this(name,message,state,null);
	 }

   public String getMessage(){
     return message;
	 }

   public void setMessage(String s){
     message=s;
	 }

   public String getName(){
     return name;
	 }

    public void setName(String s){
	   name=s;
	   }

    public int getState(){
	  return state;
	  }

    public void setState(int i){
	   state=i;
	   }
     
    public ObjectOutputStream getOOS(){
	     return oos;
		 }

    public void setOOS(ObjectOutputStream o){
	     oos=o;
		 }
    
	public Vector getUserName(){
	  return this.userName;
	  }

	public void setUserName(Vector v){
	  this.userName=v;
	  }
	}

	     
	  
