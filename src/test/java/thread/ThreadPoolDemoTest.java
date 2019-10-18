package thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class ThreadPoolDemoTest {
    @Test
    public void test() throws ExecutionException, InterruptedException {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
        threadPoolDemo.run();
    }
}
