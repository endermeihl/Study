package leetCode.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GetNums {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> getNums(int[] nums, int target){
        helper(nums,nums.length,0,new Stack<>(),target);
        return res;
    }

    private void helper(int[] nums, int len, int start, Stack<Integer> stack,int target){
        Arrays.sort(nums);
        if(target==0){
            res.add(new ArrayList<>(stack));
        }
        for(int i=start;i<len && target-nums[i]>=0;i++){
            stack.add(nums[i]);
            helper(nums,len,i+1,stack,target-nums[i]);
            stack.pop();
        }
    }
    public static void main(String[] args){
        GetNums getNums=new GetNums();
        int[] nums=new int[]{3,8,2,9,1,5,7};
        getNums.getNums(nums,7);
        System.out.println("");
    }
}
