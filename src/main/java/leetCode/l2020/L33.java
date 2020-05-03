package leetCode.l2020;

import leetCode.l2020.type.ArrayProblem;
import leetCode.l2020.type.BinarySearch;

/**
 * @author ender
 * @version 33
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 */
public class L33 implements ArrayProblem, BinarySearch {
    /**
     * @param nums   输入数组
     * @param target 目标值
     * @return 返回对应索引
     * 这个根据题目是标准的二分法查找要求
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        int i = 0, j = len - 1;
        while (i <= j) {
            if (nums[i] > target && nums[j] < target) return -1;
            if (nums[i] == target) return i;
            if (nums[j] == target) return j;
            if (nums[i] < target) i++;
            if (nums[j] > target) j--;
        }
        return -1;
    }
}
