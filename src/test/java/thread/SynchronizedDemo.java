package thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedDemo {
    int sum = 0;

    @Test
    public void testOne() throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            pool.execute(() -> {
                synchronized (this) {
                    sum = sum + 1;
                }
            });
        }
        Thread.sleep(1000);
        log.info(sum + "");
    }
}
