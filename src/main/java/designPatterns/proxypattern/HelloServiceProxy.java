package designPatterns.proxypattern;

/**
 * @author meihailei
 */
public class HelloServiceProxy {

    private HelloService helloService;

    public HelloServiceProxy(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name) {
        System.out.println("开始....");
        String result = helloService.hello(name);
        System.out.println(result);
        System.out.println("结束....");
        return result;
    }

    public String hi(String msg) {
        System.out.println("开始....");
        String result = helloService.hi(msg);
        System.out.println(result);
        System.out.println("结束....");
        return result;
    }
}
