package leetCode.l2020;

import edu.princeton.cs.algs4.In;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ender
 * @version 202
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * 示例：
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 */
public class L202 {
    /**
     * 首先编写计算方式
     * 然后根据题目的退出方式有两种一种是产生循环一种是得到1
     * @param n 输入需要判断的数字
     * @return 是否是快乐数
     */
    public boolean isHappy(int n) {
        Set<Integer> pre = new HashSet<>();
        while (n != 1 && !pre.contains(n)) {
            pre.add(n);
            n = calculate(n);
        }
        return n == 1;
    }

    private int calculate(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}
