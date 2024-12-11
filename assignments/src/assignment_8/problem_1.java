package assignment_8;

import java.util.ArrayList;
import java.util.List;

public class problem_1 {
    public static int[] orderCourses(int numCourses, int[][] prerequisites) {
        
        int[] degree = new int[numCourses], output = new int[numCourses];
        List<Integer>[] adjList = new ArrayList[numCourses];
        List<Integer> tmp;
        int pre, cour, k = 0, j = 0;
        
        for (int i = 0; i < numCourses; i++)
            adjList[i] = new ArrayList<Integer>();
        
        for (int[] pair : prerequisites) {
            pre = pair[1];
            cour = pair[0];
            adjList[pre].add(cour);
            degree[cour]++;
        }
        
        for (int i = 0; i < numCourses; i++)
            if (degree[i] == 0)
                output[k++] = i;
        
        if (k == 0)
            return new int[0];
        
        while (k < numCourses) {
            tmp = adjList[output[j++]];
            
            for (int id : tmp)
                if (--degree[id] == 0)
                    output[k++] = id;
            
            if (j == k)
                return new int[0];
        }
        
        return output;
    }
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        for (int i : orderCourses(numCourses,prerequisites)) {
            System.out.print(i + ", ");
        }
    }
}
