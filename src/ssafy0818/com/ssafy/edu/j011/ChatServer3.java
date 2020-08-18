package ssafy0818.com.ssafy.edu.j011;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer3 {

    ServerSocket ss;
    String ip="localhost";
    int port=9997;

    public void go() {
        try {
            ss=new ServerSocket(port);
            ss.setReuseAddress(true);
            System.out.println("1. Server Ready ~~~~");
            while(true){
                Socket s=ss.accept();
                ChatServer3Thread t=new ChatServer3Thread(s);
                t.start();// thread demon
            }
        } catch (IOException e) {
            System.out.println(ss);
        }finally{
            if(ss!=null){
                try {
                    ss.close();
                } catch (IOException e) {

                }
            }
            System.out.println("SS is Dead!!!");
        }
    }


    public static void main(String[] args) {

        ChatServer3 server=new ChatServer3();
        server.go();
    }
}
