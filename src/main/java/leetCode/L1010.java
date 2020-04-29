package leetCode;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author ender
 * @version 1010
 * 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * 示例 1：
 * <p>
 * 输入：[30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 * <p>
 * 输入：[60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
 *  
 * 提示：
 * <p>
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 500
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1010 {
    /**
     * @param time 歌曲时间数组
     * @return 满足条件的歌曲对数
     * 使用一个hashmap记录每个歌曲时间和60取模的计数
     * 遍历只需要判断hashmap中已有的满足条件的另一对数量并累加
     */
    public static int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int length = time.length;
        if (length <= 0) {
            return length;
        }
        Map<Integer, Integer> ans = new Hashtable<>();
        for (int value : time) {
            if (ans.containsKey(60 - value % 60)) {
                res += ans.get(60 - value % 60);
            } else if (ans.containsKey(0) && value % 60 == 0) {
                res += ans.get(0);
            }
            ans.put(value % 60, ans.getOrDefault(value % 60, 0) + 1);
        }
        return res;
    }

    /**
     * @param time 歌曲时间数组
     * @return 满足条件的对数
     * 使用了一个索引数组标记了歌曲时间对应60取模的计数
     * 然后遍历计算可以组合为60或者0的组合对
     * 注意只需要遍历一半加中间的30就可以了
     */
    public static int numPairsDivisibleBy60_2(int[] time) {
        int res = 0;
        int length = time.length;
        if (length <= 0) {
            return length;
        }
        int[] tempTime = new int[60];
        for (int i : time) {
            tempTime[i % 60]++;
        }
        for (int i = 0; i < 31; i++) {
            if (tempTime[i] == 0) continue;
            if (i == 0 || i == 30) res += tempTime[i] * (tempTime[i] - 1) / 2;
            else res += tempTime[i] * tempTime[60 - i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] times = new int[]{60, 60, 60};
        L1010.numPairsDivisibleBy60(times);
        L1010.numPairsDivisibleBy60_2(times);
    }
}
