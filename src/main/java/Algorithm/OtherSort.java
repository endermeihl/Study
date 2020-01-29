package Algorithm;

public class OtherSort {

    public static void main(String[] args){
        int[] nums=new int[]{6,5,4,3,2,1};
        int len=nums.length;
        int i=len-2;
        for (int j = 1; j <= len / 2; j++) {
            int tmp = nums[j -1];
            nums[j - 1] = nums[len - j];
            nums[len - j] = tmp;
        }
        System.out.println("");
    }
}
