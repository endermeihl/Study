package thread;


import base.BaseDemo;

public class DemoFirst extends BaseDemo implements Runnable {

    private String num;

    private Thread t;
    private String threadName;

    DemoFirst(String name) {
        threadName = name;
        logger.debug("Creating " + threadName);
    }

    @Override
    public void run() {
        logger.debug(threadName + " " + num);
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, this.threadName + "ok");
        }
        t.start();
    }

    public static void main(String[] args) {
        DemoFirst demoFirst = new DemoFirst("DemoFirst-1");
        DemoFirst demoFirst2 = new DemoFirst("DemoFirst-2");
        demoFirst.setNum("ender");
        demoFirst2.setNum("mei");
        demoFirst2.start();
        demoFirst.start();

        Thread thread = new Thread(() -> {
            System.out.println("haha");
            try {
                Thread.sleep(100);
                System.out.println("yyyy");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

}
