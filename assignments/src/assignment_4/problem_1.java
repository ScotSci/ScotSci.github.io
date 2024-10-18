package assignment_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class problem_1 {
    static int[] topKElements(int nums[], int k) {
        HashMap<Integer, Integer> values = new HashMap<>();
        List<Integer> bucket[] = new List[nums.length+1];
        int output[] = new int[k];

        for (int i : nums) {
            values.put(i, values.getOrDefault(i, 0) + 1);
        }
        for (int i : values.keySet()) {
            if (bucket[values.get(i)] == null) {
                bucket[values.get(i)] = new ArrayList<>();
            }
            bucket[values.get(i)].add(i);
        }
        int temp = 0;
        for (int i = bucket.length - 1; i >= 0 && temp < k; i--) {
            if (bucket[i] != null) {
                for (int j : bucket[i]) {
                    if (temp < k) {
                        output[temp++] = j;
                    }
                    else {
                        break;
                    }
                }
            }
        }

        return output;

    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,2,4,4};
        int k = 2;
        System.out.println("Top " + k + " most frequent numbers are:");
        int placeholder[] = topKElements(nums, k);
        for (int i : placeholder) {
            System.out.println(i);
        }
    }
}
