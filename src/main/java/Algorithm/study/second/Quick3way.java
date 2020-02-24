package Algorithm.study.second;

import edu.princeton.cs.algs4.StdRandom;

public class Quick3way extends SortBase {
    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {

    }
}
