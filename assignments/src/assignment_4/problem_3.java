package assignment_4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class problem_3 {
    static List<Integer> peekTopK(int[] arr, int k) {
        List<Integer> output = new ArrayList<>();
        if (arr == null || arr.length == 0 || k <= 0) {
            return output;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        pq.offer(new int[]{arr[0], 0});

        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int[] current = pq.poll();
            int value = current[0];
            int index = current[1];

            output.add(value);

            int leftChildIdx = 2 * index + 1;
            if (leftChildIdx < arr.length) {
                pq.offer(new int[]{arr[leftChildIdx], leftChildIdx});
            }

            int rightChildIdx = 2 * index + 2;
            if (rightChildIdx < arr.length) {
                pq.offer(new int[]{arr[rightChildIdx], rightChildIdx});
            }
        }

        return output;
    }
    public static void main(String[] args) {
        int arr[] = {15,13,12,10,8,9};
        int k = 5;
        System.out.println(k + " largest elements of a max heap:");
        for (int i : peekTopK(arr, k)) {
            System.out.println(i);
        }
    }
}
