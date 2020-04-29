package leetCode.bak;

import base.TreeNode;

public class ClosestValue {
    double change = Double.MAX_VALUE;
    int res = 0;

    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return res;

    }

    private void helper(TreeNode root, double target) {
        if (root == null) return;
        double temp = Math.abs(target - (double) root.val);
        if (temp < change) {
            res = root.val;
            change = temp;
        } else {
            helper(root.left, target);
            helper(root.right, target);
        }
    }

}
