package test;

import base.BaseDemo;

import java.util.Arrays;

public class QuickSort extends BaseDemo {

    public void quickSort(int[] nums, int left, int right) {
        if (left > right) return;
        int base = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (base <= nums[j] && i < j) {
                j--;
            }
            while (base >= nums[i] && i < j) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = base;

        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 4, 6, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, 5);
        quickSort.logger.debug(Arrays.toString(nums));
    }
}
