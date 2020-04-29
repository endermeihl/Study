package leetCode.bak;

public class MaxProfit {
    public int maxProfitCool(int[] prices) {
        int n=prices.length;
        int[][] dp =new int[n+1][2];
        dp[0][0]=0;
        dp[0][1]=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            int temp=0;
            if(i!=1){
                temp=dp[i-2][0];
            }
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);
            dp[i][1]=Math.max(dp[i-1][1],temp-prices[i-1]);
        }
        return dp[n][0];
    }

    public int maxProfitCool_2(int[] prices){
        int dp_0=0;
        int dp_1=Integer.MIN_VALUE;
        int dp_2=0;
        for (int price : prices) {
            int temp = dp_0;
            dp_0 = Math.max(dp_0, dp_1 + price);
            dp_1 = Math.max(dp_1, dp_2 - price);
            dp_2 = temp;
        }
        return dp_1;
    }
}
