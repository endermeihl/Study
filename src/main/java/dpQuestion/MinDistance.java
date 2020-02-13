package dpQuestion;

public class MinDistance {
    char[] sa1;
    char[] sa2;

    public int minDistance(String s1, String s2) {
        sa1 = s1.toCharArray();
        sa2 = s2.toCharArray();
        int i = sa1.length - 1;
        int j = sa2.length - 1;
        return dp(i, j);
    }

    private int dp(int i, int j) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (sa1[i] == sa2[j]) {
            return dp(i - 1, j - 1);
        } else {
            int n = dp(i - 1, j) + 1;
            int m = dp(i, j - 1) + 1;
            int k = dp(i - 1, j - 1) + 1;
            return Math.min(Math.min(n, m), k);
        }
    }
}
