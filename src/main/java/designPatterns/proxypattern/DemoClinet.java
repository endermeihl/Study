package designPatterns.proxypattern;

public class DemoClinet {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy(helloService);
        helloServiceProxy.hello("ender");
        helloServiceProxy.hi("Panda");
    }
}
