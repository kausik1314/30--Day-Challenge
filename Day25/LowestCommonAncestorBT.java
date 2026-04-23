/*
Problem: Lowest Common Ancestor of a Binary Tree
Platform: LeetCode
Topic: Tree / DFS

Approach:
Traverse the tree using DFS. If the current node is null, p, or q, return the current node.
Recursively search left and right.
If both left and right return non-null values, it means p and q are in different subtrees,
so the current node is the LCA.
Otherwise, return the non-null value (either left or right).

Time Complexity: O(N) in worst case
Space Complexity: O(H) for recursion stack where H is the height of tree
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class LowestCommonAncestorBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
            return root; // Found one in each subtree
        }
        
        return left != null ? left : right;
    }
}
