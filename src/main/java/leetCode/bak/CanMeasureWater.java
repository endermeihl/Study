package leetCode.bak;

public class CanMeasureWater {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x == 0 && y == 0) return z == 0;
        return z == 0 || (z % gcd(x, y) == 0);
    }

    public int gcd(int x, int y) {
        if (y == 0) return x;
        int r = x % y;
        return gcd(x, r);
    }
}
