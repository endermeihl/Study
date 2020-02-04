package Demo;

public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyChange();
}