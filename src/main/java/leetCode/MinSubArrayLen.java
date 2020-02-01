package leetCode;

public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int res=Integer.MAX_VALUE;
        int sum;
        for(int i=0;i<nums.length;i++){
            sum=0;
            for(int j=i;j<nums.length;j++){
                sum=sum+nums[j];
                if(sum>=s){
                    res=Math.min(res,j-i+1);
                    break;
                }
            }
        }

        return res!=Integer.MAX_VALUE ? res:0;
    }
    public static void main(String[] args){
        MinSubArrayLen minSubArrayLen=new MinSubArrayLen();
        minSubArrayLen.minSubArrayLen(11,new int[]{1,2,3,4,5});
    }
}
