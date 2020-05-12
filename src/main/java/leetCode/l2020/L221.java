package leetCode.l2020;

import leetCode.l2020.type.DpProblem;

/**
 * @author ender
 * @version 221
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 */
public class L221 implements DpProblem {

    /**
     * @param matrix 输入矩阵
     * @return 返回最大正方形面积
     * 标准dp问题
     */
    public int maximalSquare(char[][] matrix) {
        int l = matrix.length, r = l > 0 ? matrix[0].length : 0, maxlen = 0;
        int[][] dp = new int[l + 1][r + 1];
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= r; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxlen = Math.max(dp[i][j], maxlen);
                }
            }
        }
        return maxlen * maxlen;
    }
}
