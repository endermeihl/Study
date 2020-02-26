package Algorithm.study.first;

public interface StackInterface<Item> {
    public boolean isEmpty();

    public int size();

    public void push(Item item);

    public Item pop();
}
