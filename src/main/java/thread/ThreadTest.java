package thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadTest extends Thread {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private String in;

    private String threadName;

    public ThreadTest(String threadName) {
        this.threadName = threadName;
        logger.debug("creatThread" + this.threadName);
    }

    @Override
    public void run() {
        logger.debug(threadName + " " + this.in);
    }

    public String getNum() {
        return this.in;
    }
}
