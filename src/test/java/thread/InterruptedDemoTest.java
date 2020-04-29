package thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class InterruptedDemoTest {

    @Test
    public void testOne() throws InterruptedException {
        Thread t = new InterruptedDemo();
        t.start();
        Thread.sleep(10);
        t.interrupt();
        t.join();
        log.info("结束！！！");
    }
}
