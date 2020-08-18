package ssafy0818.com.ssafy.edu.j011;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer2 {

    ServerSocket ss;
    String ip = "localhost";
    int port = 9999;

    private void go() {
        PrintWriter pw = null;
        try {
            ss = new ServerSocket(port);
            ss.setReuseAddress(true);
            System.out.println("1. Server Ready ~~~~~");

            while (true) {
                // client가 달라붙길 기다림
                Socket s = ss.accept();
                System.out.println("2. Socket 생성");
                System.out.println(s.getLocalAddress());
                System.out.println(s.getInetAddress());
                System.out.println("붙음 !!");

                BufferedReader br = new BufferedReader(
                        new InputStreamReader(s.getInputStream()));

                pw = new PrintWriter(
                        new OutputStreamWriter(s.getOutputStream()), true);

                String msg = "";
                while ((msg = br.readLine()) != null) {
//                    System.out.println(msg);
                    pw.println("[s]" + msg);
//                    pw.flush();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
            System.out.println("SS is Dead !!!");
        }
    }

    public static void main(String[] args) {
        ChatServer2 server = new ChatServer2();

        server.go();
    }
}

