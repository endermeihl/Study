package leetCode.l2020;

/**
 * @author ender
 * @version M0107
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 不占用额外内存空间能否做到？
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 */
public class M0107 {
    /**
     * @param matrix 输入矩阵.
     *               <p>
     *               使用中间矩阵做过度，空间复杂度比较高
     *               转换逻辑是原来所在列数值不变变为行值，原来所在行值取行总值差的绝对值变列值
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) return;
        int[][] preMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                preMatrix[Math.abs(j)][Math.abs(i - n + 1)] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(preMatrix[i], 0, matrix[i], 0, n);
        }
    }

    /**
     * 原地操作
     * 通过反转矩阵
     *
     * @param matrix 输入矩阵
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        //上下对半反转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
