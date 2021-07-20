package Algorithm.study.first;

public class FixedCapacityStackOfStrings implements StackInterface<String> {
    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void push(String item) {
        a[N++] = item;
    }

    @Override
    public String pop() {
        return a[--N];
    }

    @Override
    public int size() {
        return N;
    }
}
