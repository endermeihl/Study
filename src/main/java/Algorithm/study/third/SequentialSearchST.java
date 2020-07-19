package Algorithm.study.third;


import java.util.ArrayList;
import java.util.List;

public class SequentialSearchST<Key, Value> {
    private Node first;

    private class Node {
        Node next;
        Key key;
        Value val;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
    }

    public int size() {
        int result = 0;
        for (Node x = first; x != null; x = x.next, result++) {
        }
        return result;
    }

    public List<Key> keys() {
        List<Key> result = new ArrayList<>();
        for (Node x = first; x != null; x = x.next) {
            result.add(x.key);
        }
        return result;
    }


}
