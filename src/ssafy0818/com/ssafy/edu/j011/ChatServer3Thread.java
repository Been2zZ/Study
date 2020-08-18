package ssafy0818.com.ssafy.edu.j011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatServer3Thread extends Thread {

    Socket s;
    BufferedReader br;
    PrintWriter pw;

    public ChatServer3Thread(Socket s) {
        this.s = s;
        System.out.println("2. Socket 생성");
        System.out.println(s.getLocalAddress());
        System.out.println(s.getInetAddress());
        System.out.println("이 붙음!!!");
        try {
            br=new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            pw=new PrintWriter(
                    new OutputStreamWriter(
                            s.getOutputStream()),true);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        try {
            String msg="";
            while((msg=br.readLine())!=null){
                //System.out.println(msg);
                pw.println("[s]"+msg);
                //pw.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
        }finally{
            if(pw!=null){
                pw.close();
            }
            if(s!=null){
                try {
                    s.close();
                } catch (IOException e) {

                }
            }
            System.out.println("S is Dead!!!");
        }
    }

}
