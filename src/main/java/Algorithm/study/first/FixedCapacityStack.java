package Algorithm.study.first;

public class FixedCapacityStack<Item> implements StackInterface<Item> {
    private final Item[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void push(Item item) {
        a[N++] = item;
    }

    @Override
    public Item pop() {
        return a[--N];
    }

}
