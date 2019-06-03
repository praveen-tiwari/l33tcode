/**
 * Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root,root);
    }
    int helper(TreeNode root, TreeNode child) {
        if (child == null)
            return 0;
        if (child.left == null && child.right == null && child == root.left)
            return child.val;
        return helper(child, child.left) + helper(child, child.right);
    }
}
