package assignment_8;

public class problem_2 {
    public static int division(int dividend, int divisor) {
        int sum = divisor;
        int mult = 1;

        if (dividend > 0 && divisor > 0)
            return division(-dividend, -divisor);

        else if (dividend > 0)
            return -division(-dividend, divisor);

        else if (divisor > 0)
            return -division(dividend, -divisor);

        if (divisor < dividend || dividend == 0)
            return 0;

        while ((sum + sum) < sum && (sum + sum) >= dividend) {
            sum += sum;
            mult += mult;
        }
        return mult + division(dividend - sum, divisor);
    }
    public static void main(String[] args) {
        int dividend = 10, divisor = 3;
        System.out.println(division(dividend, divisor));
    }
}
