package test;


import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoBlockQueue {
    private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new Producer("Producer1"));
        service.submit(new Consumer("Consumer1"));
        service.submit(new Consumer("Consumer2"));
        service.submit(new Consumer("Consumer3"));
    }

    private static class Producer implements Runnable {
        private String name;

        public Producer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                queue.add(i);
                System.out.println(name + " start producer " + i);
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Consumer implements Runnable {
        String name;

        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + " Consumer " + queue.poll());
            }
        }
    }
}
