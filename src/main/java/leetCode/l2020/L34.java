package leetCode.l2020;

import leetCode.l2020.type.ArrayProblem;
import leetCode.l2020.type.BinarySearch;

/**
 * @author ender
 * @version 34
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class L34 implements ArrayProblem, BinarySearch {
    /**
     * @param nums   输入数组
     * @param target 目标值
     * @return 目标缩影
     */
    public int[] searchRange(int[] nums, int target) {
        int res = binarySearch(nums, 0, nums.length - 1, target);
        if (res == -1) return new int[]{-1, -1};
        else {
            int end = res;
            int start = res;
            while (start - 1 >= 0 && nums[start - 1] == target) {
                start--;
            }
            while (end + 1 < nums.length && nums[end + 1] == target) {
                end++;
            }
            return new int[]{start, end};
        }
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) return binarySearch(nums, left, mid - 1, target);
        return binarySearch(nums, mid + 1, right, target);
    }
}
