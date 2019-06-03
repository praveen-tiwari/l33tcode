/**
 *  Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.

Construct the maximum tree by the given array and output the root node of this tree.

Example 1:

Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    /
     2  0
       \
        1

Note:

    The size of the given array will be in the range [1,1000].
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMBTHelper(nums, 0, nums.length);

    }

    private TreeNode constructMBTHelper(int[] nums, int start, int end) {
        int max = findMax(nums, start, end);
        if(max == -1)
            return null;
        TreeNode root = new TreeNode(nums[max]);
        root.left = constructMBTHelper(nums, start, max);
        root.right = constructMBTHelper(nums, max+1, end);
        return root;
    }

    private int findMax(int[] nums, int start, int end) {
        int max = -1;
        for (int i=start; i<end; i++) {
            if (max == -1)
                max = i;
            else if (nums[i] > nums[max])
                max = i;
        }
        return max;
    }
}
