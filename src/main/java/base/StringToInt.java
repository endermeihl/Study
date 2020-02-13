package base;

import java.util.Arrays;

public class StringToInt {
    public int stringToInt(String s){
        char[] nums=s.toCharArray();
        int number=0;
        for(char num:nums){
            number=number*10+(num-'0');
        }
        return number;
    }
    public static void main(String[] args){
        StringToInt stringToInt=new StringToInt();
        Arrays.asList(Integer.class,1);
        System.out.println(stringToInt.stringToInt("123"));
    }
}
