package test;


import base.TreeNode;

public class MaxPathSum {
    private int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode node){
        maxhelper(node);
        return max;
    }

    private int maxhelper(TreeNode node){
        if(node ==null) return 0;
        int left=Math.max(maxhelper(node.left),0);
        int right=Math.max(maxhelper(node.right),0);
        int maxpre=node.val+left+right;
        max=Math.max(maxpre,max);
        return node.val+Math.max(left,right);
    }
}
