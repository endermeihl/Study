package leetCode.l2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ender
 * @version 1018
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 * 示例 1：
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * 示例 2：
 * 输入：[1,1,1]
 * 输出：[false,false,false]
 * 示例 3：
 * 输入：[0,1,1,1,1,1]
 * 输出：[true,false,false,false,true,false]
 * 示例 4：
 * 输入：[1,1,1,0,1]
 * 输出：[false,false,false,false,false]
 * 提示：
 * 1 <= A.length <= 30000
 * A[i] 为 0 或 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5
 */
public class L1018 {

    /**
     * @param A 输入数组
     * @return 返回结果
     * 常规算法会溢出
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int len = A.length;
        int temp = 0;
        for (int i = 1; i < len; i++) {
            temp = A[i] + (temp << 1);
            res.add(temp % 5 == 0);
        }
        return res;
    }

    /**
     * @param A 输入数组
     * @return 返回结果
     * 常规算法会溢出,可以在原来基础上取模
     */
    public List<Boolean> prefixesDivBy5plus(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int len = A.length;
        int temp = 0;
        for (int i = 1; i < len; i++) {
            temp = (A[i] + (temp << 1)) % 5;
            res.add(temp % 5 == 0);
        }
        return res;
    }

    /**
     * @param A 输入数组
     * @return 返回结果
     * 常规算法会溢出 这个答案不是太明白
     */
    public List<Boolean> prefixesDivBy5_2(int[] A) {
        //todo 这个答案可以看下
        List<Boolean> res = new ArrayList<>();
        int sum = 0;
        for (int value : A) {
            sum += value;
            sum = sum > 9 ? sum - 10 : sum;
            res.add(sum == 0 || sum == 5);
            sum = sum * 2;
        }
        return res;
    }

    public static void main(String[] args) {
        L1018 l1018 = new L1018();
        int[] A = new int[]{1, 1, 1};
        l1018.prefixesDivBy5(A);
    }
}
