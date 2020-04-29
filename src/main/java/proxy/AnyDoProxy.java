package proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class AnyDoProxy implements InvocationHandler {

    Object target;

    AnyDoProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Begin do anything.");
        Object result = method.invoke(target, args);
        log.info("End do anything.");
        return result;
    }

    public Object creatProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
