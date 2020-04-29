package leetCode.bak;

import javax.print.SimpleDoc;
import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int right=n-1;
        int top=0;
        int low=m-1;
        while(left<=right && top<=low){
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=low;i++){
                res.add(matrix[i][right]);
            }
            right--;
            for(int i=right;i>=left;i--){
                res.add(matrix[low][i]);
            }
            low--;
            for(int i=low;i>=top;i--){
                res.add(matrix[i][left]);
            }
            left++;

        }
        return res;
    }

    public static int[][] matrix(int n){
        int left=0;
        int right=n-1;
        int top=0;
        int low=n-1;
        int index=1;
        int[][] nums=new int[n][n];
        while(left<=right && top<=low){
            for(int i=left;i<=right;i++){
                nums[top][i]=index++;
            }
            top++;
            for(int i=top;i<=low;i++){
                nums[i][right]=index++;
            }
            right--;
            for(int i=right;i>=left;i--){
                nums[low][i]=index++;
            }
            low--;
            for(int i=low;i>=top;i--){
                nums[i][left]=index++;
            }
            left++;

        }
        return nums;
    }

    public static void printmatrix(int[][] nums){
        for (int[] num : nums) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(num[j]+" ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){
        int[][] nums=matrix(5);
        printmatrix(nums);

    }
}
