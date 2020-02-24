package dpQuestion;

import edu.princeton.cs.algs4.StdOut;

public class KnappSack {
    public int knappSack(int[] w, int[] v, int bag) {
        int n = w.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[bag + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= bag; j++) {
                int temp = dp[j];
                if (w[i - 1] <= j) {
                    dp[j] = Math.max(temp, dp[j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[bag];
    }

    public int knappSackA(int[] w, int[] v, int bag) {
        int n = w.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[bag + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= bag; j++) {
                int temp = dp[j];
                for (int k = 0; k * w[i - 1] <= j; k++) {
                    dp[j] = Math.max(temp, dp[j - k * w[i - 1]] + k * v[i - 1]);
                }
            }
        }
        return dp[bag];
    }

    public static void main(String[] args) {
        KnappSack knappSack = new KnappSack();
        int[] w = new int[]{1, 3, 5, 2};
        int[] v = new int[]{1000, 5000, 8000, 2000};
        StdOut.println(knappSack.knappSackA(w, v, 7));
    }
}
