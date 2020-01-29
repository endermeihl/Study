package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    int k=0;
    String ans="";
    public String getPermutation(int n, int k) {
        this.k=k;
        if(k==0||n==0){
            return "";
        }
        int[] nums=new int[n];
        for(int i=1;i<=n;i++){
            nums[i-1]=i;
        }
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        boolean[] used=new boolean[n];
        helper(nums,n,0,path,res,used);
        return ans;
    }

    private void helper(int[] nums,int len,int depth,List<Integer> path,List<List<Integer>> res,boolean[] used){
        if(len==depth){
            res.add(new ArrayList<>(path));
        }
        if(res.size()==k){
            for (Integer integer : path) {
                ans = ans + integer;
            }
        }
        for(int i=0;i<len;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i]=true;
                helper(nums,len,depth+1,path,res,used);
                used[i]=false;
                path.remove(depth);
            }
        }
    }

    public static void main(String[] args){
        Permutation permutation=new Permutation();
        permutation.getPermutation(3,3);
    }
}
