package Algorithm.study.first;

public class GCDDemo {
    public static void main(String[] args) {
        System.out.println(gcd(10, 5));
    }

    // 欧几里得算法
    public static  int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}
