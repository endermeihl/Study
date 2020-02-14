package dpQuestion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinProblem {
    public int coinChange(int[] nums,int amount){
        int[] dp=new int[amount+1];
        //Arrays.fill(dp,amount);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            int res=Integer.MAX_VALUE;
            for(int j=0;j<nums.length && nums[j]<=i;j++) {
                res = Math.min(res, dp[i - nums[j]] + 1);
            }
            dp[i]=res;
        }
        return dp[amount];
    }
    public static void main(String[] args){
        CoinProblem coinProblem=new CoinProblem();
        int[] nums=new int[]{1,2,5};
        int amount=10;
        System.out.println(coinProblem.coinChange(nums,amount));
    }
}
