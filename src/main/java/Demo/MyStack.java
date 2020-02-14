package Demo;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue = new LinkedList<>();
    int top_elem = 0;

    public void push(int x) {
        queue.offer(x);
        top_elem = x;
    }

    public int pop() {
        int size = queue.size();
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }
        top_elem = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }

    public int top() {
        return top_elem;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
