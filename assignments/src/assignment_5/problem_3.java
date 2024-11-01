package assignment_5;

import java.util.*;

public class problem_3 {
    static class NodeState {
        int node, mask, cost;
        
        NodeState(int node, int mask, int cost) {
            this.node = node;
            this.mask = mask;
            this.cost = cost;
        }
    }
    
    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int allVisited = (1 << n) - 1;
        Queue<NodeState> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            queue.offer(new NodeState(i, mask, 0));
            visited.add(i + "," + mask);
        }
        
        while (!queue.isEmpty()) {
            NodeState current = queue.poll();
            int node = current.node, mask = current.mask, cost = current.cost;
            
            if (mask == allVisited) {
                return cost;
            }
            
            for (int neighbor : graph[node]) {
                int nextMask = mask | (1 << neighbor);
                String nextState = neighbor + "," + nextMask;
                
                if (!visited.contains(nextState)) {
                    queue.offer(new NodeState(neighbor, nextMask, cost + 1));
                    visited.add(nextState);
                }
            }
        }
        
        return -1;
    }
    
    // Driver code
    public static void main(String[] args) {
        int[][] graph1 = {{1, 2, 3}, {0}, {0}, {0}};
        int[][] graph2 = {{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}};
        
        System.out.println("Example 1 Output: " + shortestPathLength(graph1));
        System.out.println("Example 2 Output: " + shortestPathLength(graph2));
    }
}
