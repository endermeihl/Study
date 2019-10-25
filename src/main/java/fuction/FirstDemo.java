package fuction;

import base.BaseDemo;

import java.util.function.BinaryOperator;

public class FirstDemo extends BaseDemo {
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    private int i = 100;

    Runnable noArguments = () -> {
        System.out.println("111111111111");
        logger.error(String.valueOf(i));
    };

    BinaryOperator<Long> add = Long::sum;

    BinaryOperator<Long> max = Long::max;

}
