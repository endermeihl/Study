package IO;

import org.junit.Test;

import java.io.IOException;

public class FileChannelDemoTest {

    @Test
    public void test() throws IOException {
        FileChannelDemo f = new FileChannelDemo();
        f.test("C:\\Users\\ender\\Documents\\work\\SSR_for_win\\pac.txt");
    }
}
