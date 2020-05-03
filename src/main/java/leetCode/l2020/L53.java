package leetCode.l2020;

import leetCode.l2020.type.ArrayProblem;
import leetCode.l2020.type.DpProblem;

/**
 * @author ender
 * @version 53
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 */
public class L53 implements ArrayProblem, DpProblem {
    /**
     * 数组下的简单dp问题
     *
     * @param nums 输入数组
     * @return 最大连续值
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }
}
