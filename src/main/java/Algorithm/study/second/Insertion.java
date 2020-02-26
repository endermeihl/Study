package Algorithm.study.second;

public class Insertion extends SortBase {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j > 0 & less(a[i], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
