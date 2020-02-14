package dpQuestion;

public class LongOfLIS {
    public int longOfLIS(int[] nums){
        int len=nums.length;
        int[] dp=new int[len+1];
        for(int i=1;i<=len;i++){
            for(int j=1;j<len;j++){
                if(nums[i-1]>nums[j-1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp[len];
    }
}
