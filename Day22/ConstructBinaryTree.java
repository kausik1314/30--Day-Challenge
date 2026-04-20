/*
Problem: Construct Binary Tree from Preorder and Inorder Traversal
Platform: LeetCode
Topic: Trees / Divide and Conquer

Approach:
The first element in preorder is always the root. Find this root in the inorder array.
The elements to the left of the root in inorder form the left subtree, and elements to the right
form the right subtree. Recursively build the subtrees.

Time Complexity: O(N) using HashMap to find root index in inorder array
Space Complexity: O(N) for HashMap and Recursion Stack
*/

import java.util.HashMap;
import java.util.Map;

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

class ConstructBinaryTree {
    private Map<Integer, Integer> inorderMap;
    private int preorderIndex;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return arrayToTree(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;
        
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        root.left = arrayToTree(preorder, left, inorderMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderMap.get(rootValue) + 1, right);
        
        return root;
    }
}
