package thread;

import base.BaseDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo extends BaseDemo {


    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable task = new TaskRunnable();
        executorService.submit(task);
        logger.debug("----------------------");
        executorService.submit(task);
        logger.debug("+++++++++++++++++++++++");
        executorService.shutdown();
    }

    public void run2() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<Object> task = new TaskCallable();
        executorService.submit(task);
        logger.debug("----------------------");
        executorService.submit(task);
        logger.debug("+++++++++++++++++++++++");
        executorService.shutdown();
    }

}


class TaskRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("自定义线程任务在执行" + i);
        }
    }
}


class TaskCallable implements Callable<Object> {
    @Override
    public Object call() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("自定义线程任务在执行" + i);
        }
        return null;
    }
}

