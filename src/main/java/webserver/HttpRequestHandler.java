package webserver;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;

/**
 * @author ender mei
 * @create 2018-09-27  20:20
 */
public class HttpRequestHandler implements Runnable {

    private static final String CHARSET = "UTF-8";
    private static final int BUFFER_SIZE = 1024;
    private SelectionKey key;
    private Selector selector;

    HttpRequestHandler(SelectionKey key,Selector selector) {
        this.key = key;
        this.selector=selector;
    }

    private void acceptHttpRequest(Selector selector, SelectionKey key) {
        try {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            //接收连接后,注册读事件到selector
            socketChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readHttpRequest() {
        String httpStr = "";
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
        byteBuffer.clear();
        int num;
        try {
            if ((num = channel.read(byteBuffer)) != -1) {
                byteBuffer.flip();
                httpStr = Charset.forName(CHARSET).newDecoder().decode(byteBuffer).toString();
            }
        } catch (IOException e) {
            System.out.println("服务器读取错误！");
            e.printStackTrace();
        }

        return httpStr;
    }

    private String turnStringToHttpPackage(String httpPackageStr) {

        return httpPackageStr;
    }

    //我们可以在这里将字符串转换成我们想要的格式！
    private void returnHttpPackage(String httpPackageStr) {
        StringBuilder returnStr = new StringBuilder();
        returnStr.append("HTTP/1.1 200 ok\r\n");//增加响应消息行
        returnStr.append("Content-Type:text/html;charset=" + CHARSET + "\r\n");//增加响应消息头
        returnStr.append("\r\n");//空行
        returnStr.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>返回的网页</title>\n" +
                "    <style>\n" +
                "        *{\n" +
                "            background-color: cadetblue;\n" +
                "        }\n" +
                "        #requestInfo{\n" +
                "            font-size: 35px;\n" +
                "            font-family: \"Buxton Sketch\",serif;\n" +
                "            font-weight: bold;\n" +
                "            color: #001bff;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Hello!</h1><br>\n" +
                "    <h3>I'm come from localhost!</h3>\n" +
                "    <h3>And this is you request package information：</h3><br>\n" +
                "    <p id=\"requestInfo\">\n" +
                httpPackageStr +     //返回请求头信息！
                "        \n" +
                "    </p>\n" +
                "</body>\n" +
                "</html>");//响应消息体

        //System.out.println("返回内容：\n" + returnStr.toString());

        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        buffer.clear();
        try {
            buffer.put(returnStr.toString().getBytes(CHARSET));
        } catch (UnsupportedEncodingException e) {
            System.out.println("返回内容字节转换失败！");
            e.printStackTrace();
        }
        try {
            buffer.flip();
            channel.write(buffer);
        } catch (IOException e) {
            System.out.println("报文返回失败！");
            e.printStackTrace();
        }
        try {
            channel.close();
        } catch (IOException e) {
            System.out.println("channel关闭错误！");
            e.printStackTrace();
        }
    }

    @Override

    public void run() {
        if (key.isAcceptable()) {
            acceptHttpRequest(selector,key);
        } else if (key.isReadable()) {
            returnHttpPackage(turnStringToHttpPackage(readHttpRequest()));
        }
    }
}
