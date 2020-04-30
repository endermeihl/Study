package leetCode.l2020;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author ender
 * @version 0804
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入： nums = [1,2,3]
 * 输出：
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-set-lcci
 */

public class M0804 {
    /**
     * 二叉树搜索，基本迭代模版
     *
     * @param nums 传入数组
     * @return 返回List结果
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        helper(nums, len, 0, path);
        return res;
    }

    private void helper(int[] nums, int len, int start, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < len; i++) {
            path.add(nums[i]);
            helper(nums, len, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 位图解法需要研究
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int bmp = (int) Math.pow(2, nums.length);
        // 从 nums.length 个 0 遍历到 nums.length 个 1
        for (int i = 0; i < bmp; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++)
                // 将每一位右移最低位，检测其是否为1
                if ((i >>> j & 1) == 1) subset.add(nums[j]);
            subsets.add(subset);
        }
        return subsets;
    }

}
