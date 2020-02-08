package leetCode.test;

import base.TreeNode;

import java.util.Stack;

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int res=0;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(L<=node.val && node.val<=R){
                res+=node.val;
            }
            if(node.right!=null && node.val<R){
                stack.push(node.right);
            }
            if(node.left!=null && node.val>L) {
                stack.push(node.left);
            }
        }
        return  res;
    }
}
