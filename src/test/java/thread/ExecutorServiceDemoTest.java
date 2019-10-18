package thread;

import org.junit.Test;

public class ExecutorServiceDemoTest {

    @Test
    public void test() {
        ExecutorServiceDemo executorServiceDemo = new ExecutorServiceDemo();
        executorServiceDemo.run();
    }

    @Test
    public void test2() {
        ExecutorServiceDemo executorServiceDemo = new ExecutorServiceDemo();
        executorServiceDemo.run2();
    }
}
