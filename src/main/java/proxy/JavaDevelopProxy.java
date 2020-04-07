package proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class JavaDevelopProxy implements InvocationHandler {

    private Object target;

    JavaDevelopProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("code")) {
            log.info("Zack is playing for the code.");
            Object result = method.invoke(target, args);
            log.info("Zack finished code.");
            return result;
        }
        if (method.getName().equals("deBug")) {
            log.info("Zack's have no bug!No need to debug.");
            return null;
        }
        return null;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object CreatProxyObj() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
