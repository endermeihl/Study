package thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int threadNum = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNum, () -> {
            log.info("开始处理！！！");
        });
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            pool.execute(() -> {
                try {
                    Thread.sleep(1000);
                    log.info(Thread.currentThread().getName() + " 开始处理A");
                    cyclicBarrier.await();
                    log.info(Thread.currentThread().getName() + " 处理完毕A");
                    Thread.sleep(1000);
                    log.info(Thread.currentThread().getName() + " 开始处理B");
                    cyclicBarrier.await();
                    log.info(Thread.currentThread().getName() + " 处理完毕B");
                } catch (InterruptedException | BrokenBarrierException e) {
                    log.error(e.getMessage());
                }
            });
        }
    }
}
