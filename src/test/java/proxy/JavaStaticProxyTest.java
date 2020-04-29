package proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class JavaStaticProxyTest {

    @Test
    public void test() {
        Develop zack = new JavaDevelop("Zack");
        Develop zackProxy = new JavaStaticProxy(zack);
        zackProxy.code();
        zackProxy.deBug();
    }

}
