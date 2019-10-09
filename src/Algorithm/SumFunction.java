package Algorithm;

import java.util.Arrays;

public class SumFunction {

    private int sum(int[] a) {
        if (a.length == 0) {
            return 0;
        } else {
            return a[0] + sum(Arrays.copyOfRange(a, 1, a.length));
        }
    }

    public static void main(String[] args) {
        SumFunction sumFunction = new SumFunction();
        int[] a = {3, 6, 1, 2, 4, 5, 7, 9, 8, 0};
        System.out.println(sumFunction.sum(a));
    }
}
