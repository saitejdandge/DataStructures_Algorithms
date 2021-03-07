package binary_trees.flatten_binary_tree;

import binary_trees.TreeNode;

import java.util.Stack;

class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            if (n.right != null)
                s.push(n.right);
            if (n.left != null)
                s.push(n.left);
            n.left = null;
            if (!s.isEmpty())
                n.right = s.peek();
        }
    }
}
