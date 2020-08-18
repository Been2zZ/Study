package ssafy0818.com.ssafy.edu.j011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient3 {

    Socket s;
    String ip="localhost";
    int port=9997;
    BufferedReader br, brs;
    PrintWriter pw;

    public void go() {
        try {
            s=new Socket(ip, port);
            br=new BufferedReader(new InputStreamReader(System.in));
            brs=new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            pw=new PrintWriter(
                    new OutputStreamWriter(s.getOutputStream()),true);
            String msg="";
            while((msg=br.readLine())!=null){
                //System.out.println(msg);
                pw.println(msg);
                System.out.println(brs.readLine());
            }
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }finally{
            if(s!=null){
                try {
                    s.close();
                } catch (IOException e) {

                }
                System.out.println("socket is dead!!");
            }
        }
    }


    public static void main(String[] args) {
        ChatClient3 client=new ChatClient3();
        client.go();

    }
}
