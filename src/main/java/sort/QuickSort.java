package sort;

public class QuickSort {
    public static void quickSort(int[] ints, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l;
        int j = r;
        int key = ints[l];
        while (i < j) {
            while (i < j && ints[j] >= key) {
                j--;
            }
            while (i < j && ints[i] <= key) {
                i++;
            }
            if (i < j) {
                int temp = ints[i];
                ints[i] = ints[j];
                ints[j] = temp;
            }
        }
        ints[l] = ints[i];
        ints[i] = key;
        quickSort(ints, l, j - 1);
        quickSort(ints, j + 1, r);
    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 11, 4, 5, 10, 8};
        quickSort(arr, 0, arr.length - 1);
        for (int value : arr) {
            System.out.println(value);
        }
    }
}
