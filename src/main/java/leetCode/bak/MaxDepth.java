package leetCode.bak;

import base.Node;

public class MaxDepth {
    int res = 0;

    public int maxDepth(Node root) {
        helper(root, 0);
        return res;
    }

    private void helper(Node root, int depth) {
        if (root == null) return;
        if (root.children != null) {
            for (Node node : root.children) {
                helper(node, depth + 1);
                res = Math.max(res, depth);
            }
        }
        res = Math.max(depth + 1, res);
    }
}
