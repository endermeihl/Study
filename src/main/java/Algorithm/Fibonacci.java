package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public int fibonacci(int i) {
        if (i <= 1) {
            return 1;
        }
        return fibonacci(i - 1) + fibonacci(i - 2);
    }
    public  int fibonacci2(int i){
        if(i<=1) return 1;
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(1);
        for(int n=2;n<=i;n++){
            list.add(list.get(n-1)+list.get(n-2));
        }
        return list.get(i);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i <= 10; i++) {
            //调用函数进行打印
            System.out.print(fibonacci.fibonacci2(i) + "\t");
        }

    }
}
