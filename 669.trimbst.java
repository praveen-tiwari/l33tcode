/**
 *  Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:

Input:
    1
   / \
  0   2

  L = 1
  R = 2

Output:
    1
      \
       2

Example 2:

Input:
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output:
      3
     /
   2
  /
 1
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
    Integer[] vals;
    public TreeNode trimBST(TreeNode root, int L, int R) {
        List<Integer> values = new LinkedList<>();
        inOrder(root, L, R, values);
        vals = values.toArray(new Integer[0]);
        return createBST(0, vals.length-1);
    }

    public void inOrder(TreeNode root, int L, int R, List<Integer> values) {
        if(root == null)
            return;
        inOrder(root.left, L, R, values);
        if(root.val >= L && root.val <= R) {
            values.add(root.val);
        }
        inOrder(root.right, L, R, values);
    }

    public TreeNode createBST(int beg, int end) {
        if (beg>end) return null;
        int mid = beg + (end-beg)/2;
        TreeNode root = new TreeNode(vals[mid]);
        root.left = createBST(beg, mid-1);
        root.right = createBST(mid+1, end);
        return root;
    }
}
