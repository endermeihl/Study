package Algorithm.study.first;

import java.util.Iterator;

public class StackDemo<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        N++;
    }

    public Item peek() {
        if (!isEmpty()) {
            return first.item;
        }
        return null;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
}
