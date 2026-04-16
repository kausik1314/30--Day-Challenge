/*
Problem: Clone Graph
Platform: LeetCode
Topic: Graph / DFS / HashMap

Approach:
We maintain a HashMap where keys are the original nodes and values are the cloned nodes.
Traverse the graph using DFS. If a node is not in the map, create its clone, add it to map,
and recursively clone all its neighbors.

Time Complexity: O(V + E)
Space Complexity: O(V)
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class CloneGraph {
    private HashMap<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        Node clone = new Node(node.val);
        map.put(node, clone);
        
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        
        return clone;
    }
}
