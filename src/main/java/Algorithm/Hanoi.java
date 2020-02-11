package Algorithm;

public class Hanoi {
    public int hanoi(int n) {
        if (n == 1) return 1;
        else {
            return hanoi(n - 1) + 1 + hanoi(n - 1);
        }
    }

    public static void main(String[] args){
        Hanoi hanoi=new Hanoi();
        System.out.println(hanoi.hanoi(3));
    }
}
