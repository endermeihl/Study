package Callback;

public class StaticProxy {

    //静态代理的不灵活的地方
    private HelloService proxyObj;

    public StaticProxy(HelloService proxyObj) {
        this.proxyObj = proxyObj;
    }

    public void sayHello(String something) {
        proxyObj.sayHello(something);
    }

}