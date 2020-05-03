package leetCode.l2020;

import leetCode.l2020.type.ArrayProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ender
 * @version 1
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class L1 implements ArrayProblem {
    /**
     * @param nums   数组
     * @param target 目标和
     * @return 数组中和为目标和的索引对
     * 暴力解法，双层嵌套循环
     */

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * @param nums   数组
     * @param target 目标和
     * @return 数组中和为目标和的索引对
     * 这个使用了一个map作为中间存储记录已经遍历过的值
     */
    public int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (temp.containsKey(target - nums[i])) {
                return new int[]{i, temp.get(target - nums[i])};
            } else {
                temp.put(nums[i], i);
            }
        }
        return null;
    }
}
