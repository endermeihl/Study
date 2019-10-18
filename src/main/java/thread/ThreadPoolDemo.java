package thread;

import base.BaseDemo;

import java.util.concurrent.*;

public class ThreadPoolDemo extends BaseDemo {

    public void run() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        MyCallable myCallable = new MyCallable(100, 200);
        MyCallable myCallable2 = new MyCallable(10, 20);

        Future<Integer> result = executorService.submit(myCallable);
        //此 Future 的 get 方法所返回的结果类型
        Integer sum = result.get();
        logger.debug("sum=" + sum);

        result = executorService.submit(myCallable);
        sum = result.get();
        logger.debug("sum=" + sum);
        //再演示
        result = executorService.submit(myCallable2);
        sum = result.get();
        logger.debug("sum=" + sum);
    }
}

class MyCallable implements Callable<Integer> {
    //成员变量
    private int x = 5;
    private int y = 3;

    //构造方法
    public MyCallable() {
    }

    public MyCallable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() {
        return x + y;
    }
}

