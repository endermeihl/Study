package leetCode.l2020;

import edu.princeton.cs.algs4.In;
import leetCode.l2020.type.ArrayProblem;
import leetCode.l2020.type.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author ender
 * @version 39
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 */
public class L39 implements ArrayProblem, Backtracking {
    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    int len;

    /**
     * @param candidates 传入数组
     * @param target     目标和
     * @return 满足条件的结果集
     * 使用回溯法标准模板处理 这里使用了栈
     * 需要注意的是这里不允许重复
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        len = candidates.length;
        if (len == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        this.candidates = candidates;
        Arrays.sort(candidates);
        helper(target, 0, new Stack<>());
        return res;
    }

    private void helper(int pre, int start, Stack<Integer> stack) {
        if (pre == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < len && pre - candidates[i] >= 0; i++) {
            stack.push(candidates[i]);
            helper(pre - candidates[i], i, stack);
            stack.pop();
        }
    }
}
