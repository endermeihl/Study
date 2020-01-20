package leetCode;

import java.util.ArrayList;
import java.util.HashSet;

public class Three {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        HashSet<Character> se=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(se.add(s.charAt(i))){
                if(se.size()>max){
                    max++;
                }
            }else{
                i=i-se.size()+1;
                se=new HashSet<>();
                se.add(s.charAt(i));
            }
        }
        return max;
    }

    public static void main(String[] args){
        Three t=new Three();
        t.lengthOfLongestSubstring("aab");
    }
}
