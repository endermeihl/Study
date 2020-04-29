package thread;


import org.junit.jupiter.api.Test;

public class DemoFirstTest {

    @Test
    public void demoTest() {
        DemoFirst demoFirst = new DemoFirst("demoFirst-1");
        demoFirst.setNum("junit-test-1");
        demoFirst.start();
    }
}
