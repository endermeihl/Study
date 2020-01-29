package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<3){
            return res;
        }
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        while(left<right-1){
            for(int i=left+1;i<right;i++){
                if(nums[left]+nums[right]+nums[i]==0){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[i]);
                    temp.add(nums[right]);
                    res.add(temp);
                    break;
                }
            }
            if(nums[left]+nums[right]<=0){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args){
        ThreeSum three=new ThreeSum();
        int[] num=new int[]{0,0,0};
        three.threeSum(num);
    }
}
