package Algorithm;

public class BinRec {
    public int binRec(int n) {
        if (n == 1) return 1;
        else return binRec(n / 2) + 1;
    }
}
