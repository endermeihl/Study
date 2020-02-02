package exam;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {

    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left > right) return;
        int base = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] >= base) {
                j--;
            }
            while (i < j && nums[i] <= base) {
                i++;
            }
            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = base;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public static void main(String[] args){
        QuickSort quickSort=new QuickSort();
        int[] nums=new int[]{3,2,1,4,9,8,6,5,7};
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
