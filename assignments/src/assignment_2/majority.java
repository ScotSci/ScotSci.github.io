package assignment_2;

public class majority {
    public static void main(String[] args) {
        int[] nums = {8, 6, 8, 8, 10};

        String firstSentence = "Input: nums = [";
        for (int i : nums) {
            firstSentence += i + ",";
        }
        firstSentence = firstSentence.substring(0, firstSentence.length() - 1) + "]";
        System.out.println(firstSentence);
        
        findMajority(nums);
    }

    public static void findMajority(int[] nums) {
        int major = 0;
        int counter = 0;

        for (int i : nums) {
            if (counter == 0) {
                major = i;
                counter = 1;
            }
            else if (major == i) {
                counter++;
            }
            else {
                counter--;
            }
        }

        counter = 0;
        for (int i : nums) {
            if (major == i) {
                counter++;
            }
        }

        if (counter > nums.length / 2) {
            System.out.println("Output: " + major);
        }
        else {
            System.out.println("ERROR: no majority number");
            System.exit(0);
        }
    }
}
