package Algorithm.study.second;

public class Shell extends SortBase {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
        show(a);
    }

    public static void main(String[] args) {
        Shell shell = new Shell();
        Comparable[] nums = new Comparable[]{3, 1, 4, 6, 7, 8, 2, 5, 9};
        shell.sort(nums);
    }
}
