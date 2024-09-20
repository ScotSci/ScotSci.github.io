package assignment_2;

public class maximum {
    public static void main(String[] args) {
        int[] nums = {3,6,9,1};

        String firstSentence = "Input: nums = [";
        for (int i : nums) {
            firstSentence += i + ",";
        }
        firstSentence = firstSentence.substring(0, firstSentence.length() - 1) + "]";
        System.out.println(firstSentence);
        System.out.println("Output: " + maxGap(nums));
    }

    public static int maxGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int gap = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] > gap) {
                gap = nums[i] - nums[i-1];
            }
        }
        return gap;
    }
}
