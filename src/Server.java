import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static boolean flag = true;

    public static void main(String args[]) throws IOException {
        //为了简单起见，所有的异常信息都往外抛
        try {
            //创建一个服务器对象，端口3333
            ServerSocket serverSocket = new ServerSocket(3333);
            //创建一个客户端对象，这里的作用是用作多线程，必经服务器服务的不是一个客户端
            Socket client = null;


            while (flag) {
                System.out.println("服务器已启动，等待客户端请求。。。。");
                //accept是阻塞式方法，对新手来说这里很有可能出错，下面的注意事项我会说到
                client = serverSocket.accept();
                //创建一个线程，每个客户端对应一个线程
                new Thread(new EchoThread(client)).start();
                if(!flag) break;
            }
            assert client != null;
            client.close();
            serverSocket.close();
            System.out.println("服务器已关闭。");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void setFlag(boolean flagt){
        flag=flagt;
    }
}

class EchoThread implements Runnable {
    private Socket client;

    public EchoThread(Socket client) {
        this.client = client;

    }

    public void run() {
        //run不需要自己去执行，好像是线程器去执行了来着，可以去看api
        try {
            String httpRequest;
            String urlRequest;
            System.out.println("one has connected to this server!!" + client.getLocalPort());
            BufferedReader bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            httpRequest = bf.readLine();
            System.out.println(httpRequest);
            String[] type=httpRequest.split("\\?");
            //System.out.println(type[1]);
            //System.out.println("false HTTP/1.1".equals(type[1]));
            if(type.length>1&&"false HTTP/1.1".equals(type[1])){
                Server.setFlag(false);
            }else{
                //获取到url地址,请求头中是/index.html ，因此需要将/去掉
                urlRequest = httpRequest.split(" ")[1].substring(1);
                System.out.println(urlRequest);
                //检查是否有该文件，有则返回，无则报错404
                PrintWriter out = new PrintWriter(client.getOutputStream());
                //返回一个状态行
                out.println("HTTP/1.0 200 OK");
                //返回一个首部
                out.println("Content-Type:text/html;charset=utf-8");
                // 根据 HTTP 协议, 空行将结束头信息
                out.println();

                // 输出请求资源
                out.println("<h1 style='color: green'> Hello Http Server</h1>");
                out.println("你好, 这是一个 Java HTTP 服务器 demo 应用.<br>");
                out.println("您请求的路径是: " + urlRequest + "<br>");
                out.close();
            }


        } catch (IOException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error");
        }


    }

    public void recordMsg(String br) throws IOException {
        File file = new File("test.data");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file, true);
        writer.write(br + "\r\n");
        writer.close();

    }
}
