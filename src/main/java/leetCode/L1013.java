package leetCode;

/**
 * @author ender
 * @version 1013
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 * 示例 1：
 * 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 * 提示：
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 */
public class L1013 {
    /**
     * @param A 数组
     * @return 返回判断结果
     * 这个有个基本概念，分三分能相等其实就是和可以被三整除
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int res = 0;
        for (int a : A) {
            res += a;
        }
        if (res % 3 != 0) {
            return false;
        }
        int sum = res;
        int rev = res / 3;
        res = 0;
        int count = 0;
        for (int a : A) {
            res += a;
            if (res == rev) {
                count++;
                res = 0;
            }
        }
        return count == 3 || (sum == 0 && count > 3);
    }

    public static void main(String[] args) {
        L1013 l1013 = new L1013();
        int[] nums = new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println(l1013.canThreePartsEqualSum(nums));
    }
}
