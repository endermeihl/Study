package leetCode.l2020;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ender
 * @version 16
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 */
public class L16 {
    /**
     * @param nums   输入数组
     * @param target 目标和
     * @return 最接近的和
     * 先对数组进行排序
     * 然后使用双指针处理一个当前数据后以为，一个最后面
     * 判断三个数的值和目标和的差，小的就替换原来的结果
     * 同时判断这个值比target大还是小，大就后指针向前，小就前指针向后，相同就直接返回结果
     * 没有提前返回就最后返回最接近的
     */
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; i++) {
            int start = i + 1, end = len - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}
