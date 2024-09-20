package assignment_2;

public class shortest {
    public static void main(String[] args) {
        int[] nums = {1,2};
        int k = 4, output = nums.length + 1;

        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp >= k) {
                    if (j - i + 1 <= output) {
                        output = j - i + 1;
                    }
                }
            }
        }
        String firstSentence = "Input: nums = [";
        for (int i : nums) {
            firstSentence += i + ",";
        }
        firstSentence = firstSentence.substring(0, firstSentence.length() - 1) + "], k = " + k;
        System.out.println(firstSentence);

        if (output == nums.length + 1) {
            output = -1;
        }
        System.out.println("Output: " + output);
    }
}
