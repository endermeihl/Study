package Algorithm.study.first;

public class FixedCapacityStackOfStrings implements StackInterface<String> {
    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public int size() {
        return N;
    }
}
