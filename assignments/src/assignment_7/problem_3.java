package assignment_7;

import java.util.*;

public class problem_3 {
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
            // Create a list to store all edges
            List<int[]> edges = new ArrayList<>();
    
            // Add edges for well costs (virtual node 0 to all houses)
            for (int i = 0; i < wells.length; i++) {
                edges.add(new int[]{0, i + 1, wells[i]});
            }
    
            // Add edges for pipes
            for (int[] pipe : pipes) {
                edges.add(pipe);
            }
    
            // Sort edges by cost
            edges.sort(Comparator.comparingInt(edge -> edge[2]));
    
            // Union-Find (Disjoint Set Union) to keep track of connected components
            int[] parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
    
            // Kruskal's Algorithm to find MST
            int totalCost = 0;
            int edgesUsed = 0;
    
            for (int[] edge : edges) {
                int house1 = edge[0];
                int house2 = edge[1];
                int cost = edge[2];
    
                // If the houses are not already connected, connect them
                if (find(house1, parent) != find(house2, parent)) {
                    union(house1, house2, parent);
                    totalCost += cost;
                    edgesUsed++;
                    // If we have used enough edges to connect all houses, stop
                    if (edgesUsed == n) break;
                }
            }
    
            return totalCost;
        }
        // Find function for Union-Find
        public static int find(int x, int[] parent) {
            if (parent[x] != x) {
                parent[x] = find(parent[x], parent); // Path compression
            }
            return parent[x];
        }

        // Union function for Union-Find
        public static void union(int x, int y, int[] parent) {
            int rootX = find(x, parent);
            int rootY = find(y, parent);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    
        public static void main(String[] args) {
            int n = 3;
            int[] wells = {1, 2, 2};
            int[][] pipes = {{1, 2, 1}, {2, 3, 1}};
            System.out.println(minCostToSupplyWater(n, wells, pipes)); // Output: 3
    }
}

