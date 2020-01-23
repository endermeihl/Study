package Algorithm;

public class BagProblem {
    public int maxPrice(int[] price, int[] weight, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + price[i - 1]);
                }
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        BagProblem bagProblem = new BagProblem();
        int[] price = new int[]{1500, 3000, 2000, 2000};
        int[] weight = new int[]{1, 4, 3, 1};
        System.out.println(bagProblem.maxPrice(price, weight, 4, 4));
    }
}
