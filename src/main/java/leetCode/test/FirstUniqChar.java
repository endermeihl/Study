package leetCode.test;

import java.util.HashMap;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> pre=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(pre.containsKey(s.charAt(i))){
                pre.put(s.charAt(i),pre.get(s.charAt(i))+1);
            }else{
                pre.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<s.length();i++){
            if(pre.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
