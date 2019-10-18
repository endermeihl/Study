package Algorithm;

import java.util.Arrays;

public class SelectionSort {

    private int[] selectionSort(int[] a) {
        int c;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[i]) {
                    c = a[j];
                    a[j] = a[i];
                    a[i] = c;
                }
            }

        }
        return a;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] a = {3, 6, 1, 2, 4, 5, 7, 9, 8, 0};
        System.out.println(Arrays.toString(selectionSort.selectionSort(a)));
    }
}
