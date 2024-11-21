package assignment_6;

import java.util.Arrays;
import java.util.Comparator;

public class problem_3 {
    // Union-Find Helper Class
    static class UnionFind {
        private int[] parent;
        private int[] rank;
        
        public UnionFind(int n) {
            parent = new int[n + 1]; // 1-based indexing
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }
        
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX == rootY) {
                return false; // Already connected
            }
            
            // Union by rank
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            
            return true;
        }
    }
    
    public static int minimumCost(int N, int[][] connections) {
        // Sort connections by cost
        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
        
        UnionFind uf = new UnionFind(N);
        int totalCost = 0;
        int edgesUsed = 0;
        
        for (int[] connection : connections) {
            int city1 = connection[0];
            int city2 = connection[1];
            int cost = connection[2];
            
            // Try to union the cities
            if (uf.union(city1, city2)) {
                totalCost += cost;
                edgesUsed++;
                // If we have N-1 edges, all cities are connected
                if (edgesUsed == N - 1) {
                    return totalCost;
                }
            }
        }
        
        // If we used less than N-1 edges, it's impossible to connect all cities
        return -1;
    }
    
    public static void main(String[] args) {
        // Example 1
        int N1 = 3;
        int[][] connections1 = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        System.out.println(minimumCost(N1, connections1));
        
        // Example 2
        int N2 = 4;
        int[][] connections2 = {{1, 2, 3}, {3, 4, 4}};
        System.out.println(minimumCost(N2, connections2));
    }
}