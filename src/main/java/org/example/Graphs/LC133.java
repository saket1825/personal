package org.example.Graphs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LC133 {


    static class Node {
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

    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);
    }

    private Node dfs(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node currNode = new Node(node.val);
        map.put(node, currNode);
        for (Node curNode : node.neighbors) {
            currNode.neighbors.add(dfs(curNode, map));
        }
        return currNode;
    }
}
