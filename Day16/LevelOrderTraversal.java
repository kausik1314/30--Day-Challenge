/*
Problem: Binary Tree Level Order Traversal
Platform: LeetCode
Topic: Trees / BFS

Approach:
Use a Queue to perform Breadth-First Search (BFS).
At each level, iterate through all nodes currently in the queue, add their values
to a list for that level, and push their children into the queue for the next level.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                currentLevel.add(curr.val);
                
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            res.add(currentLevel);
        }
        
        return res;
    }
}
