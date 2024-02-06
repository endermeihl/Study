package base;

import com.google.common.base.Supplier;

import java.util.function.IntBinaryOperator;

public class LambdaDemo {
    public static void main(String[] args) {
        IntBinaryOperator intBinaryOperator = Integer::sum;
        System.out.println(intBinaryOperator.applyAsInt(1, 2));
    }
}
   