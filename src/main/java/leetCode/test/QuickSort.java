package leetCode.test;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int index = findIndex(nums, l, r);
            quickSort(nums, l, index - 1);
            quickSort(nums, index + 1, r);
        }
    }

    private int findIndex(int[] nums, int l, int r) {
        int temp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= temp) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= temp) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = temp;
        return l;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = new int[]{3, 4, 7, 6, 8, 2, 5, 1, 9};
        quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        String s="";
    }
}
