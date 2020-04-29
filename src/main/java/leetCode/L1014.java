package leetCode;

/**
 * @author ender
 * @version 1014
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 * 示例：
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 * 提示：
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
 */
public class L1014 {
    /**
     * @param A 输入数组
     * @return 返回最高分
     * 暴力解法，会超时
     */
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (res < A[i] + A[j] + i - j) {
                    res = A[i] + A[j] + i - j;
                }
            }
        }
        return res;
    }

    /**
     * @param A 输入数组
     * @return 返回最高分
     * 动态规划
     * target=A[i]+i+A[j]-j
     * 取target最大值
     */
    public int maxScoreSightseeingPairDP(int[] A) {
        int max = 0;
        int pre = A[0];
        int len = A.length;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, pre + A[i] - i);
            pre = Math.max(pre, A[i] + i);
        }
        return max;
    }
}
