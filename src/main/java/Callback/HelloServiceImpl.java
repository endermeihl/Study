package Callback;

public class HelloServiceImpl implements HelloService {
    public void sayHello(String something) {
        System.out.println("hello, " + something);
    }
}