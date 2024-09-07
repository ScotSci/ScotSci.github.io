import java.util.Arrays;

public class median {
    public static void main(String[] args) throws Exception
    {
        int input1[] = {1, 2};
        int input2[] = {3, 4};
        int merged[] = mergeAlgorithm(input1, input2);
        String firstSentence = "input1 = [";
        String secondSentence = "merged array = [";

        for (int i : input1) {
            if (i == input1[0]) {
                firstSentence += i;
            }
            else
            {
                firstSentence += ", " + i;
            }
        }
        firstSentence += "], input2 = [";
        for (int i : input2) {
            if (i == input2[0]) {
                firstSentence += i;
            }
            else
            {
                firstSentence += ", " + i;
            }
        }
        firstSentence += "]";

        for (int i : merged) {
            if (i == merged[0]) {
                secondSentence += i;
            }
            else
            {
                secondSentence += ", " + i;
            }
        }
        secondSentence += "] and median is ";


        System.out.println(firstSentence);
        System.out.println("Output: " + medianAlgorithm(merged));
        System.out.println("Explanation: " + secondSentence + medianAlgorithm(merged));

    }

    public static int[] mergeAlgorithm (int[] input1, int[] input2)
    {
        int placeholder[] = new int[input1.length + input2.length];

        for(int i = 0; i < input1.length; i++)
        {
            placeholder[i] = input1[i];
        }

        for(int i = 0; i < input2.length; i++)
        {
            placeholder[input1.length + i] = input2[i];
        }
        Arrays.sort(placeholder);
        return placeholder;
    }

    public static double medianAlgorithm (int[] input)
    {
        int len = input.length;
        if(len % 2 != 0)
        {
            return (double)input[len / 2];
        }
        System.out.println("check");
        return (double)(input[(len - 1) / 2] + input[len / 2]) / 2;
    }
}