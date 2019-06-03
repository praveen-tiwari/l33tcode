/**
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:





We should return its level order traversal:

[
     [1],
     [3,2,4],
     [5,6]
]



Note:

    The depth of the tree is at most 1000.
    The total number of nodes is at most 5000.

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> level1 = new LinkedList<Node>();
        Queue<Node> level2 = new LinkedList<Node>();
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null) {
            return levelOrder;
        }
        level1.offer(root);
        while(!level1.isEmpty() || !level2.isEmpty()) {
            List<Integer> list1 = new ArrayList<>();
            while (!level1.isEmpty()) {
                Node node = level1.remove();
                if(node != null) {
                    for(Node child:node.children) {
                        level2.offer(child);
                    }
                    list1.add(node.val);
                }
            }
            if(!list1.isEmpty())
                levelOrder.add(list1);
            List<Integer> list2 = new ArrayList<>();
            while (!level2.isEmpty()) {
                Node node = level2.remove();
                if(node != null) {
                    for(Node child:node.children) {
                        level1.offer(child);
                    }
                    list2.add(node.val);
                }
            }
            if(!list2.isEmpty())
                levelOrder.add(list2);
        }
        return levelOrder;
    }
}
