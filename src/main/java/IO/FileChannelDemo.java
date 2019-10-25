package IO;

import base.BaseDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo extends BaseDemo {
    public void test(String file) throws IOException {
        FileInputStream fin = new FileInputStream(file);
        // 获取通道
        FileChannel fc = fin.getChannel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 读取数据到缓冲区
        fc.read(buffer);
        buffer.flip();
        StringBuilder s = new StringBuilder();
        while (buffer.remaining() > 0) {
            byte b = buffer.get();
            s.append((char) b);
            //System.out.print(((char) b));
        }
        logger.debug(s.toString());
        fin.close();
    }
}