package Callback;

import base.BaseDemo;

public class LambdaDemo extends BaseDemo {

    public void testOne() throws Exception {
        new Thread(()->{logger.debug("this is a lambdaDemo");});
    }
}
