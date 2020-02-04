package Demo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RealSubject implements Subject {
    ArrayList<Observer> observerArrayList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observerArrayList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerArrayList.remove(observer);
    }

    @Override
    public void notifyChange() {
        for (Observer observer : observerArrayList) {
            observer.update();
        }
    }
}
