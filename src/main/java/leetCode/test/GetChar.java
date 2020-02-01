package leetCode.test;

import java.util.HashMap;

public class GetChar {
    public char getChar(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> pre = new HashMap<>();
        for (char c : chars) {
            pre.put(c, pre.getOrDefault(c, 0) + 1);

        }
        int max = 0;
        char res = 0;
        for (char c : pre.keySet()) {
            if (pre.get(c) > max) {
                max = pre.get(c);
                res = c;
            }
        }
        return res;
    }

    public static void main(String[] args){
        GetChar getChar=new GetChar();
        System.out.println(getChar.getChar("aaaaaabcccccdef"));
    }
}
