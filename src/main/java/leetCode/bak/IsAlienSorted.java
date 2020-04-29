package leetCode.bak;

import java.util.HashMap;

public class IsAlienSorted {
    HashMap<Character,Integer> pre=new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=0;i<order.length();i++){
            pre.put(order.charAt(i),i);
        }
        pre.put('#',-1);
        for(int i=1;i<words.length;i++){
            if(!checknotWrong(words[i-1],words[i])){
                return false;
            }
        }
        return true;
    }
    private boolean checknotWrong(String s1,String s2){
        for(int i=0;i<s1.length()||i<s2.length();i++){
            char a=i<s1.length()?s1.charAt(i):'#';
            char b=i<s2.length()?s2.charAt(i):'#';
            if(pre.get(a)<pre.get(b)){
                return true;
            }else if(pre.get(a)==pre.get(b)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        IsAlienSorted isAlienSorted=new IsAlienSorted();
        String[] words=new String[]{"apple","app"};
        String order="abcdefghijklmnopqrstuvwxyz";

    }
}
