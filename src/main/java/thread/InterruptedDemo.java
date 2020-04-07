package thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InterruptedDemo extends Thread {

    @Override
    public void run() {
        while (!interrupted())
            log.info("do " + Thread.currentThread().getName());
    }

}
