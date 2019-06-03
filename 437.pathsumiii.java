/**
 * You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
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
    public int pathSum(TreeNode root, int sum) {
        return pathSumHelper(root, 0, sum);
    }
    int pathSumHelper(TreeNode root, int curr, int sum) {
        if (root == null)
            return 0;
        int num = 0;
        if(curr + root.val == sum)
            num += 1;

        num += pathSumHelper(root.left, 0, sum);
        num += pathSumHelper(root.left, curr + root.val, sum);
        num += pathSumHelper(root.right, 0, sum);
        num += pathSumHelper(root.right, curr + root.val, sum);
        return num;
    }
}
