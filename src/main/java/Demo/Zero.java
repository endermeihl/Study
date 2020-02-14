package Demo;

import java.util.Arrays;

public class Zero {
    public int[] moveZero(int[] nums){
        int len=nums.length;
        int[] res=new int[len];
        int i=0;
        for(int num:nums){
            if(num==0){
                i++;
            }
        }
        for(int num:nums){
            if(num!=0){
                res[i++]=num;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Zero zero=new Zero();
        int[] nums=new int[]{0,-1,9,0,1,3,0,-2,-3,4,2,0,-3};
        zero.deMoveZero(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void deMoveZero(int[] nums){
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                for(int k=i;k>j;k--){
                   int tmp=nums[k];
                   nums[k]=nums[k-1];
                   nums[k-1]=tmp;
                }
                j++;
            }
        }
    }
}
