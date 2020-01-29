package base;

public class StackDemo {
    private int[] stackArray;

    public StackDemo(int size) {
        stackArray = new int[size];
        stackArray[0] = 0;
    }

    public void push(int x) {
        stackArray[0]++;
        stackArray[stackArray[0]] = x;
    }

    public boolean isEmpty() {
        return stackArray[0] == 0;
    }

    public int pop(){
        if(isEmpty()){
            return -1;
        }else {
            stackArray[0]--;
            return stackArray[stackArray[0]+1];
        }
    }

    public static void main(String[] args){
        StackDemo stackDemo=new StackDemo(5);
        System.out.println(stackDemo.pop());
        stackDemo.push(1);
        stackDemo.push(2);
        stackDemo.push(3);
        System.out.println(stackDemo.pop());
        System.out.println(stackDemo.pop());
        stackDemo.push(4);
        System.out.println(stackDemo.pop());
    }
}
