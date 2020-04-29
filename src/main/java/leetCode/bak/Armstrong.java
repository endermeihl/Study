package leetCode.bak;

public class Armstrong {
    public boolean isArmstrong(int N) {
        String num = N + "";
        int len = num.length();
        int res = 0;
        for (char n : num.toCharArray()) {
            res += ((n - '0')) ^ len;
        }
        return res == N;
    }

    public static void main(String[] args) {
        Armstrong armstrong = new Armstrong();
        armstrong.isArmstrong(153);
    }

}
