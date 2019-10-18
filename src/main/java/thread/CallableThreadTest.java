package thread;

import base.BaseDemo;

import java.util.concurrent.Callable;

public class CallableThreadTest extends BaseDemo implements Callable<Integer> {
    @Override
    public Integer call() {
        int i = 0;
        for (; i < 100; i++) {
            logger.debug(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}
