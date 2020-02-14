package Demo;

import base.TreeNode;

public class TreeNodeDemo {
    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public boolean isInBST(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        if (target > root.val) {
            return isInBST(root.right, target);
        }
        return isInBST(root.left, target);
    }

    public TreeNode insertInBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) root.right = insertInBST(root.right, val);
        if (root.val > val) root.left = insertInBST(root.left, val);
        return root;
    }

    public TreeNode deleleNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleleNode(root.right, minNode.val);
        } else if (root.val > val) {
            root.left = deleleNode(root.left, val);
        } else if (root.val < val) {
            root.right = deleleNode(root.right, val);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
