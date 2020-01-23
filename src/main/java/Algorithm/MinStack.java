package Algorithm;

class MinStack {
    int[] stack=new int[10000];
    int min=Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        stack[0]=0;
    }
    
    public void push(int x) {
        stack[0]=stack[0]+1;
        stack[stack[0]]=x;
        if(x<min){
            min=x;
        }
        
    }
    
    public void pop() {
        int x=stack[stack[0]];
        stack[0]=stack[0]-1;
        if(x==min){
            changeMin();
        }
        if(stack[0]==0){
            min=Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return stack[stack[0]];
    }
    
    public int getMin() {
        return min;
    }
    
    private void changeMin(){

        if(stack[0]!=0){
             min=Integer.MAX_VALUE;
        }
        for(int i=1;i<stack[0]+1;i++){
            if(stack[i]<min){
                min=stack[i];
            }
        }
    }

    public static void main(String[] args){
        String s="";
        s.toCharArray();
        System.out.println(0b100+1);

    }
}