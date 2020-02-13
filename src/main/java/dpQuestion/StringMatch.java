package dpQuestion;

import base.StackDemo;

import java.util.Stack;

public class StringMatch {
    public boolean isMatch(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (j < s2.length()) {
            if (i >= s1.length()) {
                return false;
            }
            if (s1.charAt(j++) != s2.charAt(i++)) {
                return false;
            }
        }
        return j == s1.length();
    }

    public boolean isMatch2(String s1, String s2) {
        if (s2.isEmpty()) return s1.isEmpty();
        boolean first_match = !s1.isEmpty() && ('.' == s2.charAt(0) || s1.charAt(0) == s2.charAt(0));
        if (s2.length() >= 2 && s2.charAt(1) == '*') {
            return isMatch(s1, s2.substring(2)) || (first_match && isMatch2(s1.substring(1), s2));
        } else {
            return first_match && isMatch2(s1.substring(1), s2.substring(1));
        }


    }

    public static void main(String[] args) {
        StringMatch match = new StringMatch();
        String s1 = "abbc";
        String s2 = "ab*c";
        System.out.println(match.isMatch2(s1, s2));
    }
}
