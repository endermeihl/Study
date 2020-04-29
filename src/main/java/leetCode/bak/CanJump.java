package leetCode.bak;

public class CanJump {
    public boolean canJump(int[] nums) {
        if(nums.length<=1){
            return true;
        }
        if(nums[0]==0){
            return false;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                for(int j=i-1;j>=0;j++){
                    if(nums[j]>i-j){
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static  void main(String[] args){
        int[] nums=new int[]{3,2,1,0,4};
        CanJump canJump=new CanJump();
        canJump.canJump(nums);
    }
}
