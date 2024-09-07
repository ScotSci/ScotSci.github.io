public class find_element {
    public static void main(String[] args) throws Exception
    {
        int input[] = {5, 7, 7, 8, 8, 10};
        int target = 8;
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
        int placeholder[] = {-1, -1};
        for(int x = 0; x < input.length; x++)
        {
            if(input[x] == target)
            {
                if(placeholder[0] == -1) {
                    placeholder[0] = x;
                    placeholder[1] = x;
                }
                if(placeholder[1] < x)
                {
                    System.out.println("check");
                    placeholder[1] = x;
                }
            }
        }
        return placeholder;
    }
}