package assignment_7;

import java.util.*;

public class problem_2 {
    public static int networkDelayTime(int[][] times, int n, int k) {
        // Create adjacency list representation of the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        // Use a PriorityQueue to process nodes by the shortest distance (min-heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0}); // Starting with the source node

        // Keep track of the shortest time to each node
        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int time = current[1];

            if (dist.containsKey(node)) continue; // Skip if we've already found the shortest path to this node
            dist.put(node, time);

            if (!graph.containsKey(node)) continue;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                if (!dist.containsKey(nextNode)) {
                    pq.offer(new int[]{nextNode, time + weight});
                }
            }
        }

        // If not all nodes are reached, return -1
        if (dist.size() < n) return -1;

        // Return the maximum time among all nodes
        return dist.values().stream().max(Integer::compare).orElse(-1);
    }

    // Example usage
    public static void main(String[] args) {
        int[][] times1 = {{1, 2, 1}};
        System.out.println(networkDelayTime(times1, 2, 1)); // Output: 1

        int[][] times2 = {{1, 2, 1}};
        System.out.println(networkDelayTime(times2, 2, 2)); // Output: -1
    }
}

