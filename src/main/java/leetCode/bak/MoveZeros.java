package leetCode.bak;

import java.util.Arrays;

public class MoveZeros {
    public void moveZeros(int[] nums) {
        int index = nums.length - 1;
        for (int i=index;i>=0;i--) {
            if (nums[i] != 0) {
                nums[index--] = nums[i];
            }
        }
        while (index >= 0) {
            nums[index--] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeros.moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }
}
