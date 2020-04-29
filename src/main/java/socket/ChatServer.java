package socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            Socket socket = serverSocket.accept();

            System.out.println(socket.getInetAddress() + "上线了");

            connection = new Connection(socket);

            //监听控制台，发送消息，服务端也可以发送消息
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String sendMsg;
            while ((sendMsg = br.readLine()) != null) {
                connection.send(sendMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disConnect();
            }
        }
    }

}