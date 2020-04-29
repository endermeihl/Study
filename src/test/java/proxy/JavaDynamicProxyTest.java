package proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class JavaDynamicProxyTest {

    @Test
    public void testDoZackProxy() {
        JavaDynamicProxy javaDynamicProxy = new JavaDynamicProxy();
        javaDynamicProxy.doZackProxy();
    }
}
