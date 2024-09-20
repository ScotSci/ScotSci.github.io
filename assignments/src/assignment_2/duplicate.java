package assignment_2;

public class duplicate {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        String output = "";
        int[] letterCount = new int[26];
        boolean[] letterBool = new boolean[26];
        for (int i = 0; i < s.length(); i++){
            letterCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            letterCount[s.charAt(i) - 'a']--;
            if (!letterBool[s.charAt(i) - 'a']) {
                int len = output.length();
                while (len > 0 && output.charAt(len - 1) > s.charAt(i) && letterCount[output.charAt(len - 1) - 'a'] > 0) {
                    letterBool[output.charAt(len - 1) - 'a'] = false;
                    output = output.substring(0, len - 1);
                    len--;
                }

                output += s.charAt(i);
                letterBool[s.charAt(i) - 'a'] = true;
            }
        }

        
        System.out.println("Input: s = " + s);
        System.out.println("Output: " + output);
    }
}
