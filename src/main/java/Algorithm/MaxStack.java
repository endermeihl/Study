package Algorithm;

import java.util.Stack;

class MaxStack {
    
    private Stack<Integer> stack=new Stack<>();
    private int max=Integer.MIN_VALUE;

    /** initialize your data structure here. */
    public MaxStack() {
    }
    
    public void push(int x) {
        if(x>max){
            max=x;
        }
        stack.push(x);
    }
    
    public int pop() {
        int x=stack.pop();
        if(x==max){
         changeMax();
        }
        return x;
    }
    
    public int top() {
        return stack.get(0);
    }
    
    public int peekMax() {
        return max;
    }
    
    public int popMax() {
        int x=max;
        int index =stack.search(max);
        stack.remove(Integer.valueOf(max));
        changeMax();
        return x;
    }
    
    private void changeMax(){
        max=Integer.MIN_VALUE;
           for(int i:stack){
               if(i>max){
                   max=i;
               }
           } 
    }

    public static void main(String[] args){
        MaxStack stack=new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        stack.top();
        stack.popMax();
        stack.top();
        stack.peekMax();
        stack.pop();
        stack.top();

    }
}