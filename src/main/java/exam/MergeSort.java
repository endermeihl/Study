package exam;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);

    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    private void merge(int[] nums, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            temp[i++] = nums[l] < nums[r] ? nums[l++] : nums[r++];
        }
        while (l <= mid) {
            temp[i++] = nums[l++];
        }
        while (r <= right) {
            temp[i++] = nums[r++];
        }
        System.arraycopy(temp, 0, nums, left, right - left + 1);
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] nums = new int[]{3, 4, 2, 1, 5, 6, 8, 9, 7};
        mergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
