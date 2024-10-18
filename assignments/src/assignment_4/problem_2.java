package assignment_4;

import java.util.ArrayList;
import java.util.List;

public class problem_2 {
    static List<Integer> closestKElements(int arr[], int k, int x) {
        List<Integer> output = new ArrayList<>();
        int lower = 0, upper = arr.length - 1;
        while (upper - lower >= k) {
            if (Math.abs(arr[lower] - x) > Math.abs(arr[upper] - x)) {
                lower++;
            } else {
                upper--;
            }
        }
        while (upper >= lower) {
            output.add(arr[lower++]);
        }

        return output;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int k = 4, x = -1;
        System.out.println(k + " closest elements to " + x + " are:");
        for (int i : closestKElements(arr, k, x)) {
            System.out.println(i);
        }
    }
}
