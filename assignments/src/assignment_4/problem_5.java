package assignment_4;

import java.util.Arrays;
import java.util.PriorityQueue;

public class problem_5 {
    static int[] kthSmallestPrime(int[] arr, int k) {
        Arrays.sort(arr);
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                maxHeap.offer(new double[]{(double) arr[i] / arr[j], arr[i], arr[j]});

                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        double[] res = maxHeap.poll();
        return new int[]{(int) res[1], (int) res[2]};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int k = 3;
        int[] result = kthSmallestPrime(arr, k);
        System.out.println("The " + k + "th smallest prime is: " + result[0] + "/" + result[1]); // Output: 2/5
    }
}
