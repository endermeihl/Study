package Algorithm;

import java.util.ArrayList;

public class Fibonacci {
    public int fibonacci(int i) {
        if (i <= 1) {
            return 1;
        }
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i <= 10; i++) {
            //调用函数进行打印
            System.out.print(fibonacci.fibonacci(i) + "\t");
        }

    }
}
