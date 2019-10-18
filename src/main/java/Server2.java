
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server2 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(2222);
        while(true){
            try{
                Socket client = server.accept();
                OutputStream out = client.getOutputStream();
                DataOutputStream outStream = new DataOutputStream(client.getOutputStream());
                outStream.write("Hello".getBytes());
                InputStream in = client.getInputStream();
                byte[] buf = new byte[1024];
                in.read(buf);
                in.close();
                System.out.println("request from client " + client.getInetAddress().getHostAddress());
                System.out.println(new String(buf));
                PrintWriter o = new PrintWriter(client.getOutputStream());
                //返回一个状态行
                o.println("HTTP/1.0 200 OK");
                //返回一个首部
                o.println("Content-Type:text/html;charset=utf-8");
                // 根据 HTTP 协议, 空行将结束头信息
                o.println();

                // 输出请求资源
                o.println("<h1 style='color: green'> Hello Http Server</h1>");
                o.println("你好, 这是一个 Java HTTP 服务器 demo 应用.<br>");
                o.println("您请求的路径是: "  + "<br>");
                o.close();
                //client.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}