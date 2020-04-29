package proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

@Slf4j
public class JavaDynamicProxy {

    public void doZackProxy() {
        JavaDevelop zack = new JavaDevelop("zack");
        Develop zackProxy = (Develop) Proxy.newProxyInstance(zack.getClass().getClassLoader(),
                zack.getClass().getInterfaces(), (proxy, method, args) -> {
                    if (method.getName().equals("code")) {
                        log.info("Zack is playing for the code");
                        return method.invoke(zack, args);
                    }
                    if (method.getName().equals("deBug")) {
                        log.info("Zack's have no bug!No need to debug");
                        return null;
                    }
                    return null;
                });
        zackProxy.code();
        zackProxy.deBug();
    }
}
