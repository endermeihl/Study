package leetCode.l2020;

/**
 * @author ender
 * @version 11
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 */
public class L11 {
    /**
     * @param height 高度数组
     * @return 返回最大储水量
     * 双指针，前后同时开始移动
     * 注意那个指针指向的高度低就往中间走
     * 逻辑上只有高度升高才有可能比现在的情况蓄水更多
     */
    public int maxArea(int[] height) {
        int len = height.length;
        int l = 0;
        int r = len - 1;
        int max = 0;
        while (l < r) {
            max = Math.max(Math.min(height[l], height[r]) * (r - l), max);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
