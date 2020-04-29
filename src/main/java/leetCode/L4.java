package leetCode;

/**
 * @author ender
 * @version 4
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
public class L4 {
    /**
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @return 中位数
     * 暂时还只会暴力解法，将连个有序数组合并后处理
     * 实际应该使用二分法直接处理
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] pre = merge(nums1, nums2);
        int len = pre.length;
        double res = 0.0;
        if (len % 2 == 0) {
            res = ((double) pre[len / 2] + (double) pre[len / 2 - 1]) / 2;
        } else {
            res = pre[len / 2];
        }
        return res;
    }

    /**
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 合并后的数组
     */
    private int[] merge(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] mergeNums = new int[l1 + l2];
        int i = 0;
        int n1 = 0;
        int n2 = 0;
        while (n1 < l1 && n2 < l2) {
            mergeNums[i++] = nums1[n1] <= nums2[n2] ? nums1[n1++] : nums2[n2++];
        }
        while (n1 < l1) {
            mergeNums[i++] = nums1[n1++];
        }
        while (n2 < l2) {
            mergeNums[i++] = nums2[n2++];
        }
        return mergeNums;

    }
}
