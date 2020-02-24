package Algorithm.study.first.work;

public class ArrayWork {
    public boolean[][] arrayWork(int n) {
        boolean[][] a = new boolean[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                a[i][j] = gcd(i, j) == 1;
            }
        }
        return a;   }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        int p = a % b;
        return gcd(b, p);
    }
}
