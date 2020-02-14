package Demo;

import java.util.Arrays;
import java.util.Stack;

public class StackDemo {
    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }

    public int[] nextGreaterElement2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2*n - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i%n]) {
                stack.pop();
            }
            ans[i%n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i%n]);
        }
        return ans;
    }


    public static void main(String[] args){
        StackDemo stackDemo=new StackDemo();
        int[] nums=new int[]{2,1,2,4,3};
        System.out.println(Arrays.toString(stackDemo.nextGreaterElement2(nums)));
        nums=new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(stackDemo.dailyTemperatures(nums)));

    }

    public int[] dailyTemperatures(int[] nums){
        int n=nums.length;
        int[] ans=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            ans[i]=stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }
        return ans;
    }
}
