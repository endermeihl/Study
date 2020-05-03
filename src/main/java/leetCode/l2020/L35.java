package leetCode.l2020;

import leetCode.l2020.type.ArrayProblem;

/**
 * @author ender
 * @version 35
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 */
public class L35 implements ArrayProblem {
    /**
     * @param nums   输入数组
     * @param target 目标值
     * @return 索引位置
     */
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) return target;
        if (nums[mid] > target) return binarySearch(nums, left, mid - 1, target);
        return binarySearch(nums, mid + 1, right, target);
    }
}
