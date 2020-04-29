package proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class AnyDoProxyTest {

    @Test
    public void test() {
        Anything ender = new ThingOne();
        Anything enderProxy = (Anything) new AnyDoProxy(ender).creatProxy();
        enderProxy.doSomething("Ender");

    }
}
