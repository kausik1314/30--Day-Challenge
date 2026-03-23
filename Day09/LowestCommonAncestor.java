/*
Problem: Lowest Common Ancestor of a Binary Search Tree
Platform: LeetCode
Topic: Trees / BST

Approach:
Take advantage of BST properties. If both p and q values are less than the root, 
the LCA is in the left subtree. If both are greater, the LCA is in the right subtree.
Otherwise, the root is the LCA.

Time Complexity: O(h) where h is the height of the tree
Space Complexity: O(1) iterative
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        
        while (curr != null) {
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } else {
                return curr;
            }
        }
        
        return null;
    }
}
