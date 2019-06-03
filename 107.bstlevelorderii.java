/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> pq = new LinkedList<>();
        Queue<TreeNode> cq = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        pq.offer(root);
        if(root == null)
            return res;
        while(!pq.isEmpty() || !cq.isEmpty()) {
            List<Integer> list1 = new ArrayList<>();
            while(!pq.isEmpty()) {
                TreeNode node = pq.poll();
                if(node.left != null) cq.offer(node.left);
                if(node.right != null) cq.offer(node.right);
                list1.add(node.val);
            }
            if(!list1.isEmpty())
                res.add(0, list1);
            List<Integer> list2 = new ArrayList<>();
            while (!cq.isEmpty()) {
                TreeNode node = cq.poll();
                if(node.left != null) pq.offer(node.left);
                if(node.right != null) pq.offer(node.right);
                list2.add(node.val);
            }
            if(!list2.isEmpty())
                res.add(0, list2);
        }
        return res;
    }
}
