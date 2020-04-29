package leetCode.bak;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> pre=new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        helper(root,0);
        List<Double> res=new ArrayList<>();
        for(List<Integer> num:pre){
            res.add(num.stream().mapToDouble(Number::doubleValue).average().getAsDouble());
        }
        return res;
    }
    private void helper(TreeNode root,int depth){
        if(root==null) return;
        if(depth==pre.size()){
            pre.add(new ArrayList<>());
        }
        pre.get(depth).add(root.val);
        if(root.left!=null) helper(root.left,depth+1);
        if(root.right!=null) helper(root.right,depth+1);
    }
}