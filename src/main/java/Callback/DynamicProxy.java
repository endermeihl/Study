package Callback;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy<T> implements InvocationHandler {
        
    //这里是泛型，通配型很强
    private T proxyObj;
 
    public DynamicProxy(T proxyObj) {
        this.proxyObj = proxyObj;
    }
 
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----------------------impl myself----------------------");
        //反射
        return method.invoke(proxyObj, args);
    }
}
