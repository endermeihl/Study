package Algorithm;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    private PriorityQueue<Item> queue;
    private int index;

    public PriorityQueueExample(int maxsize) {
        queue = new PriorityQueue<>(maxsize);
        index = 0;
    }

    public void push(String item, int priority) {
        if (queue.size() >= queue.size()) {
            queue.poll();
        }
        queue.offer(new Item(item, priority, index++));
    }

    public String pop() {
        return queue.poll().getItem();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void setMaxsize(int maxsize) {
        while (queue.size() > maxsize) {
            queue.poll();
        }
    }

    public String[] getHead(int n) {
        String[] result = new String[Math.min(n, queue.size())];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll().getItem();
        }
        return result;
    }

    public String[] getTail(int n) {
        String[] result = new String[Math.min(n, queue.size())];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll().getItem();
        }
        return result;
    }

    private class Item implements Comparable<Item> {
        private String item;
        private int priority;
        private int index;

        public Item(String item, int priority, int index) {
            this.item = item;
            this.priority = priority;
            this.index = index;
        }

        public String getItem() {
            return item;
        }

        public int getPriority() {
            return priority;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Item other) {
            if (priority != other.priority) {
                return Integer.compare(priority, other.priority);
            } else {
                return Integer.compare(index, other.index);
            }
        }
    }
}