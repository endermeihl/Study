package Demo;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stackMain = new Stack<>();
    private Stack<Integer> stackTemp = new Stack<>();


    public void push(int x) {
        stackMain.push(x);
    }

    public int pop() {
        peek();
        return stackTemp.pop();
    }

    public int peek() {

        if (stackTemp.isEmpty()) {
            while (!stackMain.isEmpty()) {
                stackTemp.push(stackMain.pop());
            }

        }
        return stackTemp.peek();
    }

    public boolean empty() {
        return stackMain.isEmpty() && stackTemp.isEmpty();
    }
}
