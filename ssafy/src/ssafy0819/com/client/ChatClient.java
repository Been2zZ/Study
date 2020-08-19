package ssafy0819.com.client;

import  java.io.*;
import  java.net.*;
import  java.awt.*;
import  java.awt.event.*;

import ssafy0819.com.Data;

public class ChatClient{
	Socket socket;
	ObjectInputStream     ois;
	ObjectOutputStream    oos;
	Thread            t;
	Frame      first,second;
	Panel      p,p1,p2,p3;;
	Label      serverLabel,IDLabel,stateLabel,userLabel,commLabel,userCountLabel;
	TextField  serverTextField,IDTextField,transTextField;
	Button     conn,transmission;
	List      userList;
	TextArea  commText;
	ChatClientThread cct;
	String name;

	public void firstView(){

		first=new Frame("chat v1.0");
		//처음 GUI 종료 처리
		first.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				first.dispose();
				System.exit(0);
			}
		});



		serverLabel=new Label("Server",Label.CENTER);
		IDLabel=new Label("I D",Label.CENTER);
		serverTextField=new TextField();
		IDTextField=new TextField();
		conn=new Button("연 결");
		//버튼에 이벤트 감시자를 띄우고,handler class의 actionPerformed에 처리를 위임,전달한다.
		conn.addActionListener(new Handler());



		p=new Panel(new GridLayout(2,2));
		p.add(serverLabel);
		p.add(serverTextField);
		p.add(IDLabel);
		p.add(IDTextField);

		first.add(p,"Center");
		first.add(conn,"South");
		first.setSize(300,100);
		Dimension d=first.getToolkit().getScreenSize();
		first.setLocation(d.width/2-first.getWidth()/2,d.height/2-first.getHeight()/2);
		first.setVisible(true);
	}

	public void secondView(){

		second=new Frame("Chat v1.0 second");
		//두번 째 GUI 종료처리
		second.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				disConnection();
				second.dispose();
				System.exit(0);
			}
		});

		stateLabel=new Label("접속중........",Label.LEFT);
		stateLabel.setBackground(Color.blue);
		stateLabel.setForeground(Color.white);
		userLabel=new Label("사용자명",Label.CENTER);
		commLabel=new Label("대화내용",Label.LEFT);
		userCountLabel=new Label("초기화",Label.CENTER);
		userList=new List();
		commText=new TextArea();
		transTextField=new TextField(30);
		transmission=new Button("전송");
		transTextField.addActionListener(new Handler());
		transmission.addActionListener(new Handler());


		p1=new Panel(new BorderLayout());

		p1.add(userLabel,"North");
		p1.add(userList,"Center");
		p1.add(userCountLabel,"South");

		p2=new Panel(new BorderLayout());
		p2.add(commLabel,"North");
		p2.add(commText,"Center");

		p3=new Panel();
		p3.add(transTextField);
		p3.add(transmission);

		second.add(stateLabel,"North");
		second.add(p1,"West");
		second.add(p2,"Center");
		second.add(p3,"South");

		second.setSize(600,500);
		Dimension d=second.getToolkit().getScreenSize();
		second.setLocation(d.width/2-second.getWidth()/2,d.height/2-second.getHeight()/2);
		second.setBackground(Color.lightGray);
		second.setVisible(true);
	}

	//서버쪽과 연결하는 메서드
	public void connection(String serverName,int port) throws IOException{
		socket=new Socket(serverName,port);
		System.out.println(serverName+"에 접속되었습니다.");

		oos=new ObjectOutputStream(socket.getOutputStream());
		ois=new ObjectInputStream(socket.getInputStream());

		System.out.println("outputStream을 열었습니다.");
		Data d=new Data(name,"님이 접속하셨습니다.",Data.처음접속);
		oos.writeObject(d);

		System.out.println("InputStream을 열었습니다.");
		cct=new ChatClientThread(ois,this);
		t=new Thread(cct);
		t.start();
	}

	public void disConnection() {
		try{
			Data d=new Data(name,"님이 접속종료.",Data.접속종료);
			oos.writeObject(d);
		}catch(IOException e){}
		t=null;
	}


	//버튼에 이벤트 처리를 전담할 inner-class
	public class Handler implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==conn){
				String server=serverTextField.getText();
				name=IDTextField.getText();
				first.setVisible(false);
				first.dispose();
				secondView();

				try{
					connection(server,5555);
				}catch(IOException e1){
					System.out.println("connection 중 Exception이 발생했습니다.");
				}

				stateLabel.setText("["+server+"]"+"에 접속되었습니다.--UserID:"+name);
			}
			else if(e.getSource()==transmission || e.getSource()==transTextField){
				try{
					oos.writeObject(new Data(name,transTextField.getText(),Data.대화중));
				}catch(IOException e2){
					System.out.println("대화중 IOEXception이 발생 하였습니다.");
				}
				transTextField.setText("");
			}//else if
		}//actionperformed
	}//inner class

	public static void main(String args[]){
		ChatClient c=new ChatClient();
		c.firstView();
	}
}


           

