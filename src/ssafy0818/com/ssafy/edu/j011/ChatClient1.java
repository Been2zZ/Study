package ssafy0818.com.ssafy.edu.j011;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient1 {

    Socket s;
    String ip = "localhost";
    int port = 9998;
    BufferedReader br;
    PrintWriter pw;

    private void go() {
        try {
            s = new Socket(ip, port);
            br = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(
                    new OutputStreamWriter(s.getOutputStream()), true);
            String msg = "";
            while((msg = br.readLine()) != null) {
//                System.out.println(msg);
                pw.println(msg);
            }

        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
            System.out.println("SS is Dead !!!");
        }
    }

    public static void main(String[] args) {
        ChatClient1 client = new ChatClient1();
        client.go();
    }
}
