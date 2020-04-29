package socket;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        Connection connection;
        try {
            Socket socket = new Socket("localhost", 9090);
            System.out.println("已连接服务器");

            connection = new Connection(socket);

            //监听控制台，发送消息，客户端发送消息
            InputStream s = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = s.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
            System.out.println("测试");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}