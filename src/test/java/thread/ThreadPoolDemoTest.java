package thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

public class ThreadPoolDemoTest {
    @Test
    public void test() throws ExecutionException, InterruptedException {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
        threadPoolDemo.run();
    }
}
