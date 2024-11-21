package assignment_6;

public class problem_2 {
    public static int cycleLength(int[] edges) {
        int ans = -1, time = 1;
        int[] timeVisited = new int[edges.length];
    
        // Iterate through each node in the graph
        for (int i = 0; i < edges.length; ++i) {
          if (timeVisited[i] > 0) {continue;}

          final int startTime = time;
          int u = i;

          // Traverse the graph until the end of the path is reached or a visited node is encountered
          while (u != -1 && timeVisited[u] == 0) {
            timeVisited[u] = time++;
            u = edges[u];
          }

          // If a cycle is found that includes the current node, update the answer
          if (u != -1 && timeVisited[u] >= startTime)
            ans = Math.max(ans, time - timeVisited[u]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] edges = {3,3,4,2,3};
        
        System.out.println(cycleLength(edges));
    }
}
