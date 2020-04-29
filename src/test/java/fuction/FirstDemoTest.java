package fuction;

import org.junit.jupiter.api.Test;

public class FirstDemoTest {

    @Test
    public void test() {
        FirstDemo firstDemo = new FirstDemo();
        firstDemo.noArguments.run();
        System.out.println("111111111111");
        firstDemo.setI(99);
        firstDemo.noArguments.run();
        System.out.println(firstDemo.add.apply(2L, 3L));
        System.out.println(firstDemo.max.apply(2L, 3L));
    }
}
