package leetCode.l2020;

import com.alibaba.druid.support.monitor.annotation.MTable;

import java.util.HashSet;

/**
 * @author ender
 * @version 3
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class L3 {
    /**
     *
     * @param s 输入字符串
     * @return 结果
     * 使用hashset判断字符是否存在
     */
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        int max=0;
        HashSet<Character> pre=new HashSet<>();
        for(int i=0;i<len;i++){
            if(pre.add(s.charAt(i))){
                max= Math.max(max,pre.size());
            }else {
                while (!pre.add(s.charAt(i))){
                    pre.remove(s.charAt(i-pre.size()));
                }
            }
        }
        return max;
    }
}
