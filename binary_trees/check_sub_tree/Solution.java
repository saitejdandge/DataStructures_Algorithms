package binary_trees.check_sub_tree;


import binary_trees.TreeNode;

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (isSame(s, t))
            return true;
        else
            return isSubtree(s.left, t) || isSubtree(s.right, t);

    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return s == null && t == null;
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        return left.val == right.val && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }

    boolean areMirror(TreeNode a, TreeNode b) {
        /* Base case : Both empty */
        if (a == null || b == null)
            return a == b;
        /* Both non-empty, compare them recursively
           Note that in recursive calls, we pass left
           of one tree and right of other tree */
        return a.val == b.val
                && areMirror(a.left, b.right)
                && areMirror(a.right, b.left);
    }
}

