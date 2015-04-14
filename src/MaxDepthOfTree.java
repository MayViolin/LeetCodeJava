/**
 * User: May
 * Date: 2015-02-11
 * Time: 16:03
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class MaxDepthOfTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null ) {
            return 1;
        } else if (root.left == null && root.right != null) {
            return 1 + maxDepth(root.right);
        } else if (root.right == null && root.left != null) {
            return 1 + maxDepth(root.left);
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            if (leftDepth > rightDepth)
                return leftDepth + 1;
            else return rightDepth + 1;
        }
    }

    public static void main(String[] args) {
        MaxDepthOfTree mdof = new MaxDepthOfTree();

    }
}
