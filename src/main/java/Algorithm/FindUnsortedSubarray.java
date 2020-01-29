package Algorithm;

import java.util.Hashtable;
import java.util.Stack;

public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                right = Math.max(right, i);
                continue;
            }
            if (nums[i] < nums[i - 1]) {
                right = Math.max(right, i);
                break;
            }
        }
        return right - left >= 0 ? right - left + 1 : 0;
    }

    public static void main(String[] args) {
        FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();
        int[] nums = new int[]{3, 4, 1, 0, 0, 4};
        findUnsortedSubarray.canJump(nums);
    }

    public int islandPerimeter(int[][] grid) {
        int girth = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    if (i - 1 < 0) {
                        girth++;
                    }
                    if (j - 1 < 0) {
                        girth++;
                    }
                    if (i == grid.length - 1) {
                        girth++;
                    }
                    if (j == grid[i].length - 1) {
                        girth++;
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == 0) {
                        girth++;
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] == 0) {
                        girth++;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 0) {
                        girth++;
                    }
                    if (j + 1 < grid[i].length && grid[i][j + 1] == 0) {
                        girth++;
                    }
                }
            }
        }
        return girth;
    }

    public boolean canJump(int[] nums) {
        boolean jump;
        for (int i = 0; i < nums.length; i++) {
            jump = false;
            if (nums[i] == 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] > i - j) {
                        jump = true;
                        break;
                    }
                }
                if (!jump) {
                    return false;
                }
            }
        }
        Stack<Integer> s=new Stack<>();
        return true;
    }
}
