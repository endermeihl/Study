package Algorithm.study.first;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key, int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == key) return mid;
            else if (nums[mid] > key) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }

    public static int rankNO(int key, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = new int[]{1, 3, 9, 10, 2, 3, 4, 9, 4, 5};
        Arrays.sort(whitelist);
        StdOut.println(rank(5, whitelist));
    }
}
