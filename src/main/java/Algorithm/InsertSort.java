package Algorithm;

import java.util.Arrays;

public class InsertSort {
    public void insertSort(int[] nums){
        int len=nums.length;
        for(int i=1;i<len;i++){
            int temp=nums[i];
            int j=i-1;
            while(j>=0 && nums[j]>temp){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=temp;
        }
    }

    public static void main(String[] args){
        InsertSort insertSort=new InsertSort();
        int[] nums=new int[]{3,4,6,7,9,8,0,1,2};
        insertSort.insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
