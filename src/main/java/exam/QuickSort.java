package exam;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums,int l,int r){
        if(l>r) return;
        int base=nums[l];
        int i=l;
        int j=r;
        while (i!=j){
            while (nums[j]>=base && j>i){
                j--;
            }
            while (nums[i]<=base && j>i){
                i++;
            }
            if(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        nums[l]=nums[i];
        nums[i]=base;
        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }

    public static void main(String[] args){
        QuickSort quickSort=new QuickSort();
        int[] nums=new int[]{3,4,2,1,5,6,8,9,7};
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
