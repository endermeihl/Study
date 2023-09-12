package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public int[] sort(int[] ins) {
        mergeSort(ins, 0, ins.length - 1);
        return ins;
    }

    public void mergeSort(int[] ins, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(ins, middle + 1, right);
        mergeSort(ins, left, middle);
        merge(ins, left, middle, right);
    }

    public void merge(int[] ins, int left, int middle, int right) {
        if (left >= right) {
            return;
        }
        int[] tmpArray = new int[right - left + 1];
        int i = 0;
        int l = left;
        int r = middle + 1;
        while (l <= middle && r <= right) {
            tmpArray[i++] = ins[l] < ins[r] ? ins[l++] : ins[r++];
        }
        while (l <= middle) {
            tmpArray[i++] = ins[l++];
        }
        while (r <= right) {
            tmpArray[i++] = ins[r++];
        }
        System.arraycopy(tmpArray, 0, ins, left, right - left + 1);
    }

    public static void main(String[] args) {
        int[] ins = new int[]{3, 6, 7, 1, 2, 5, 4, 8, 10, 9};
        MergeSort mergeSort = new MergeSort();
        int[] nums1 = new int[]{1, 3, 5, 7, 9};
        int[] nums2 = new int[]{2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(mergeSort.sort(ins)));
        System.out.println(Arrays.toString(mergeSort.merge(nums1, nums2)));
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int left = nums1.length;
        int right = nums2.length;
        int[] temp = new int[left + right];
        int l = 0;
        int r = 0;
        int i = 0;
        while (l < left && r < right) {
            temp[i++] = nums1[l] < nums2[r] ? nums1[l++] : nums2[r++];
        }
        while (l < left) {
            temp[i++] = nums1[l++];
        }
        while (r < right) {
            temp[i++] = nums2[r++];
        }
        return temp;
    }


}
