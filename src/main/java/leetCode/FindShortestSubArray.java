package leetCode;

import java.util.HashMap;

public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        int n=nums.length;
        HashMap<Integer,helper> map=new HashMap<>();
        int d=0;
        int num=n;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).setEnd(i);
            }else{
                map.put(nums[i],new helper(i));
            }
            d=Math.max(map.get(nums[i]).getD(),d);
        }
        for(int key:map.keySet()){
            if(map.get(key).getD()==d){
                num=Math.min(num,map.get(key).getLen());
            }
        }
        return num;
    }

    public static void main(String[] args){
        FindShortestSubArray findShortestSubArray=new FindShortestSubArray();
        int[] nums=new int[]{1,2,2,3,1};
        findShortestSubArray.findShortestSubArray(nums);
    }
}

class helper{
    private int begin;
    private int end;
    private int d;
    private int len;
    public helper(int begin){
        this.begin=begin;
        this.d=1;
        this.len=1;
    }
    public int getBegin(){
        return begin;
    }
    public void setBegin(int begin){
        this.begin=begin;
    }
    public int getEnd(){
        return end;
    }
    public void setEnd(int end){
        setLen(end-begin+1);
        setD(getD()+1);
        this.end=end;
    }
    public int getD(){
        return d;
    }
    public void setD(int d){
        this.d=d;
    }
    public int getLen(){
        return len;
    }
    public void setLen(int len){
        this.len=len;
    }
}
