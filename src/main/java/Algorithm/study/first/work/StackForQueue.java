package Algorithm.study.first.work;

import Algorithm.study.first.StackDemo;

public class StackForQueue<Item> {
    private StackDemo<Item> stackOne;
    private StackDemo<Item> stackTwo;

    public StackForQueue() {
        this.stackOne = new StackDemo<>();
        this.stackTwo = new StackDemo<>();
    }

    public int size() {
        return stackOne.size() + stackTwo.size();
    }

    public boolean isEmpty() {
        return stackOne.isEmpty() && stackTwo.isEmpty();
    }

    public void enqueue(Item item) {
        stackOne.push(item);
    }

    public Item peek() {
        if (stackTwo.isEmpty()) {
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
        }
        return stackTwo.peek();
    }

    public Item dequeue() {
        if (stackTwo.isEmpty()) {
            peek();
        }
        return stackTwo.pop();
    }
}
