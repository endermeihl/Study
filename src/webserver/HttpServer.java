package webserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ender mei
 */
public class HttpServer {

    public static void main(String[] args) {
        new HttpServer().start();
    }

    public void start() {

        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            //注册接收连接的事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("服务器启动监听 " + 8080 + " 端口...");
            //持续select事件
            beginAccept(selector);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void beginAccept(Selector selector) {
        while (true) {
            try {
                if (selector.select() > 0) {
                System.out.println("当前连接数:" + selector.keys().size());
                System.out.println("检测到活跃的连接数:" + selector.selectedKeys().size());
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> it = keys.iterator();
                    while (it.hasNext()) {
                        SelectionKey key = it.next();
                        new Thread(new HttpRequestHandler(key, selector)).start();
                        it.remove();
                    }
                }
            } catch (IOException e) {
                System.out.println("selector处理请求失败！");
                e.printStackTrace();
            }
        }
    }
}