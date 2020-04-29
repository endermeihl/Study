package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class Connection extends Thread {
    private Socket socket;
    private PrintWriter pw;
    private BufferedReader br;

    public Connection(Socket socket) {
        super();
        this.socket = socket;
        //直接开启线程
        this.start();
    }

    //发送信息的方法
    public void send(String msg) {
        //使用socket将msg写出去
        try {
            if (pw == null) {
                pw = new PrintWriter(socket.getOutputStream());
            }
            //输出信息
            pw.println(msg);
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //关闭socket
    public void disConnect() {
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception ignored) {
            }
        }
    }


    //接收功能(线程)
    public void run() {
        //不断读取服务器数据
        try {
            if (br == null) {
                br = new BufferedReader
                        (new InputStreamReader(socket.getInputStream()));
            }
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (SocketException e) {
            System.out.println("下线了");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getIp() {
        return this.socket.getInetAddress().getHostAddress();
    }

}
