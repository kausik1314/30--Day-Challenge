/*
Problem: Binary Tree Maximum Path Sum
Platform: LeetCode
Topic: Tree / DFS / Dynamic Programming

Approach:
Use a global variable maxPathSum. Perform a post-order traversal (DFS).
For each node, compute the max path sum of its left and right subtrees.
A node can form a path through itself encompassing both children (left + right + node.val).
Update the global maximum if this path is the largest found so far.
Return to the parent node the max path taking ONLY ONE child branch (max(left, right) + node.val).

Time Complexity: O(N)
Space Complexity: O(H) where H is tree height for recursion stack
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTreeMaxPathSum {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        
        // Ignore paths with negative sums
        int leftMax = Math.max(0, dfs(node.left));
        int rightMax = Math.max(0, dfs(node.right));
        
        // Max path passing through the current node
        int currentPathSum = node.val + leftMax + rightMax;
        maxSum = Math.max(maxSum, currentPathSum);
        
        // Return the max path extending downwards to parent
        return node.val + Math.max(leftMax, rightMax);
    }
}
