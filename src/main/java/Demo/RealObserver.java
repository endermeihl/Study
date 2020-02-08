package Demo;


public class RealObserver implements Observer {

    @Override
    public void update() {
        System.out.println("接收到了通知");
    }
}
