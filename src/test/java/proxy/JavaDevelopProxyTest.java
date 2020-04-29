package proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class JavaDevelopProxyTest {

    @Test
    public void test() {
        Develop zack = new JavaDevelop("Zack");
        Develop zackProxy = (Develop) new JavaDevelopProxy(zack).CreatProxyObj();
        zackProxy.code();
        zackProxy.deBug();
    }
}
