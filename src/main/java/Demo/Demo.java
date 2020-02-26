package Demo;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Comparator;

public class Demo {
    public void test() {
        StdOut.print(StdRandom.uniform());
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.test();
        String[] ars = new String[]{"10", "0001", "111001", "1", "0"};
        Arrays.sort(ars, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(Arrays.toString(ars));
    }
}
