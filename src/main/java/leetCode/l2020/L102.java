package leetCode.l2020;

import base.TreeNode;
import leetCode.l2020.type.TreeNodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ender
 * @version 102
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 */
public class L102 implements TreeNodeProblem {
    /**
     *
     * @param root 二叉树根节点
     * @return 二叉树层序遍历结果
     */
    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root,int depth){
        if(root==null) return;
        if(depth==result.size()){
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        if(root.left!=null){
            helper(root.left,depth+1);
        }
        if(root.right!=null){
            helper(root.right,depth+1);
        }
    }
}
