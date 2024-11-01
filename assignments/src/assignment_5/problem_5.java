package assignment_5;

import java.util.ArrayList;
import java.util.List;

public class problem_5 {
    public static List<Integer> lexicalOrder(int n) {
    List<Integer> result = new ArrayList<>();
    int current = 1;

    for (int i = 0; i < n; i++) {
        result.add(current);

        if (current * 10 <= n) {
            current *= 10;
        } else {
            if (current >= n) current /= 10;
            current++;
            while (current % 10 == 0) {
                current /= 10;
            }
        }
    }

    return result;
}

public static void main(String[] args) {
    int n1 = 13;
    System.out.println("Lexicographical Order for n = " + n1 + ": " + lexicalOrder(n1));

    int n2 = 2;
    System.out.println("Lexicographical Order for n = " + n2 + ": " + lexicalOrder(n2));
}
}
