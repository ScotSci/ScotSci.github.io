public class two_sum {
    public static void main(String[] args) throws Exception
    {
        int input[] = {3, 5, 6, 9, 10};
        int target = 9;
        int output[] = algorithm(input, target);
        String firstSentence = "input = [";
        for (int i : input) {
            if (i == input[0]) {
                firstSentence += i;
            }
            else
            {
                firstSentence += ", " + i;
            }
        }
        firstSentence += "], target = " + target;
        
        System.out.println(firstSentence);
        System.out.println("output = [" + output[0] + ", " + output[1] + "]");
    }

    public static int[] algorithm (int[] input, int target)
    {
        int output[] = new int[2];
        for(int x = 0; x < input.length; x++)
        {
            for(int y = x + 1; y < input.length; y++)
            {
                if (input[x] + input[y] == target)
                {
                    output[0] = x;
                    output[1] = y;
                    return output;
                }
            }
        }
        return output;
    }
}