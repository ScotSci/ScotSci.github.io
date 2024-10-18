package assignment_4;

import java.util.Deque;
import java.util.LinkedList;

public class problem_4 {
    static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // Create a prefix sum array
        long[] prefixSums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        // Deque to store the indices of the prefix sums
        Deque<Integer> deque = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            // Check if we can form a valid subarray
            while (!deque.isEmpty() && prefixSums[i] - prefixSums[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            // Maintain a monotonic increasing deque
            while (!deque.isEmpty() && prefixSums[i] <= prefixSums[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.addLast(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, -1, 2};
        int k = 3;
        System.out.println("The shortest subarray is: " + shortestSubarray(nums, k)); // Output: 2
    }
}
