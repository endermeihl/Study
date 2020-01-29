package leetCode.test;

public class MergeSort {
    public static void sort(int[] nums) {
        int len = nums.length;
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, mid + 1, right);
        mergeSort(nums, left, mid);
        merge(nums, left, mid, right);

    }

    private static void merge(int[] nums, int left, int mid, int right) {
        if (left >= right) return;
        int[] tmpArray = new int[right - left + 1];
        int i = 0;
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            tmpArray[i++] = nums[l] <= nums[r] ? nums[l++] : nums[r++];
        }
        while (l <= mid) {
            tmpArray[i++] = nums[l++];
        }
        while (r <= right) {
            tmpArray[i++] = nums[r++];
        }
        System.arraycopy(tmpArray, 0, nums, left, right - left + 1);
    }
}
