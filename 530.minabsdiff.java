/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).



Note: There are at least two nodes in this BST.
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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inOrder(root, inorder);
        int min = Integer.MAX_VALUE;
        Integer[] sorted = inorder.toArray(new Integer[0]);
        for(int i=0; i<sorted.length -1; i++) {
            int diff = Math.abs(sorted[i] - sorted[i+1]);
            if (min > diff)
                min = diff;
        }
        return min;
    }
    void inOrder(TreeNode root, List<Integer> inorder) {
        if (root == null)
            return;
        inOrder(root.left, inorder);
        inorder.add(root.val);
        inOrder(root.right, inorder);
    }
}
