/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBST(nums, 0, nums.length);
    }
    private TreeNode arrayToBST(int[] nums, int i, int j)
    {
        if(i >= j)
            return null;
        TreeNode root = new TreeNode(nums[(i + j)/2]);
        root.left = arrayToBST(nums, i, (i + j)/2);
        root.right = arrayToBST(nums, (i + j)/2 + 1, j);
        return root;
    }
}
