package dpQuestion;

import static java.lang.Integer.compareUnsigned;
import static java.lang.Integer.min;

public class Demo_One {
    int i = 0, j = 0, k = 0;

    public int coinChange(int amount) {
        if (amount == 0) {
            return 0;
        }
        int cost = amount;
        if (amount >= 1) {
            i++;
            cost = Math.min(coinChange(amount - 1), cost) + 1;
        }
        if (amount >= 2) {
            j++;
            cost = Math.min(coinChange(amount - 2), cost) + 1;
        }
        if (amount >= 5) {
            k++;
            cost = Math.min(coinChange(amount - 5), cost) + 1;
        }
        return cost;
    }

    public int coinChangeP(int[] coin, int amount) {
        i = 0;
        j = 0;
        k = 0;
        int length = coin.length;
        int[] f = new int[amount + 1];
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            f[i] = amount;
            for (int value : coin) {
                if (i >= value) {
                    this.i++;
                    f[i] = Math.min(f[i], f[i - value] + 1);
                }
            }
        }
        return f[amount] > amount ? -1 : f[amount];
    }

    public static void main(String[] args) {
        Demo_One demo_one = new Demo_One();
        System.out.println(demo_one.coinChange(11));
        System.out.println(demo_one.i + ":" + demo_one.j + ":" + demo_one.k);
        int[] coin = new int[]{1, 2, 5};
        System.out.println(demo_one.coinChangeP(coin, 11));
        System.out.println(demo_one.i + ":" + demo_one.j + ":" + demo_one.k);
    }
}
