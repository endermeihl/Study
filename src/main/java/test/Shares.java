package test;

import java.util.Arrays;

public class Shares {
    int buy;
    int sell;
    public int[] sharesBest(int[] nums){
        int dp_0=0;
        int dp_1=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            dp_0=Math.max(dp_0,dp_1+nums[i]);
            dp_1=Math.max(dp_1,-nums[i]);
            if(dp_0==dp_1+nums[i]) {
                sell = i;
            }
        }
        return new int[]{dp_0,sell};
    }

    public static void main(String[] args){
        Shares shares=new Shares();
        int[] nums=new int[]{7,2,3,5,6,1};
        System.out.println(Arrays.toString(shares.sharesBest(nums)));
    }
}
