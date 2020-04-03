package thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ConcurrentDemoFirst {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        log.info("开始");
        for (int i = 0; i < 100; i++) {
            pool.execute(() -> log.info("thread name = " + Thread.currentThread().getName()));
        }
        pool.shutdown();
    }
}
