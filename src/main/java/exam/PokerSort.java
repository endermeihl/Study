package exam;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PokerSort {
    public int[] getRealSort(int[] nums){
        int len=nums.length;
        int[] res=new int[len];
        int which=len%2==0 ?-1:1;
        int i=0;
        int j=len-1;
        int m=len-1;
        while(i<=j){
            if(which==-1){
                res[m--]=nums[j--];
            }else{
                res[m--]=nums[i++];
            }
            which*=-1;
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums=new int[]{5,3,1,2,4,6};
        PokerSort pokerSort=new PokerSort();
        System.out.println(Arrays.toString(pokerSort.getRealSort(nums)));
    }
}
