package thread;

import base.BaseDemo;

public class DisplayMessage extends BaseDemo implements Runnable {
    private String message;

    public DisplayMessage(String message) {
        this.message = message;
    }

    public void run() {
        while (true) {
            logger.debug(message);
        }
    }
}
