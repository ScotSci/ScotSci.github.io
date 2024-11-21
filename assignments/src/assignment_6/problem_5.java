package assignment_6;

public class problem_5 {
    public static double pow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }
    public static void main(String[] args) {
        int n = -2;
        double x = 2.0;

        System.out.println(pow(x,n));
    }
}
