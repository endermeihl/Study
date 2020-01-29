package base;

public class StackDemo2 {
    private int[] stackArray;
    int head = 1;
    int tail = 1;

    public StackDemo2(int size) {
        stackArray = new int[size];
    }

    public void enqueue(int x) {
        stackArray[tail] = x;
        if (tail == stackArray.length) {
            tail = 1;
        } else {
            tail++;
        }
    }

    public int dequeue() {
        int x = stackArray[head];
        if (head == stackArray.length) {
            head = 1;
        } else {
            head++;
        }
        return x;
    }
}
