package leetCode.bak;

public class MaxSumDivThree {
    public int maxSumDivThree(int[] nums) {
        int[] dp=new int[]{0,0,0};
        //Arrays.sort(nums);
        for (int num : nums) {
            int temp = num % 3;
            if (temp == 0) {
                dp[0] = dp[0] + num;
            } else if (temp == 2) {
                dp[2] = dp[2]==0?num:dp[1]+dp[2]+num;
                dp[0] = Math.max(dp[0], dp[1] == 0 ? 0 : dp[1] + num);
            } else {
                dp[1] = dp[1]==0?num:dp[1]+dp[2]+num;
                dp[0] = Math.max(dp[0], dp[2] == 0 ? 0 : dp[2] + num);
            }
        }
        return dp[0];
    }

    public static void main(String[] args){
        MaxSumDivThree maxSumDivThree=new MaxSumDivThree();
        int[] nums=new int[]{1,2,3,4,4};
        maxSumDivThree.maxSumDivThree(nums);
    }
}
