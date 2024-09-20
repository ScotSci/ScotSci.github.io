package assignment_2;

import java.util.Random;

public class largest {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        String firstSentence = "Input: nums = [";
        for (int i : nums) {
            firstSentence += i + ",";
        }
        firstSentence = firstSentence.substring(0, firstSentence.length() - 1) + "]";
        System.out.println(firstSentence);

        System.out.println("Output: " + find_K_Largest(nums, 0 , nums.length - 1, nums.length - k));
    }

    public static int find_K_Largest(int[] nums, int left, int right, int K_Num) {
        if (left == right) {
            return nums[left];
        }
        Random randNum = new Random();
        int temp = left + randNum.nextInt(right - left + 1);
        int pivot = partition(nums, left, right, temp);
        int output = 0;

        if (K_Num == pivot) {
            output = nums[K_Num];
        }
        else if (K_Num < pivot) {
            output = find_K_Largest(nums, left, pivot - 1, K_Num);
        }
        else {
            output = find_K_Largest(nums, pivot + 1, right, K_Num);
        }
        return output;
    }

    public static int partition(int[] nums, int left, int right, int pivot) {
        int newPivot = nums[pivot];
        move(nums, pivot, right);
        int temp = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < newPivot) {
                move(nums, i, temp);
                temp++;
            }
        }
        move(nums, right, temp);
        return temp;
    }

    public static void move(int[] nums, int x, int y) {
        int store = nums[x];
        nums[x] = nums[y];
        nums[y] = store;
    }
}
