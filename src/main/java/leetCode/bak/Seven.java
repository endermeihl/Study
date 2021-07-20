package leetCode.bak;

public class Seven {
    public int reverse(int x) {
        int result = 0;
        String t = String.valueOf(x);
        int i = t.length();
        while (x / 10 > 0) {
            i--;
            result += x % 10 * Math.pow(10, i);
        }
        return result;
    }
}
