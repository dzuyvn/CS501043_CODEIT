import java.util.*;
import java.lang.Math;

public class Statistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] x = new int[n];
        double sum = 0.0;

        if (n > 1) 
            System.out.println("Enter " + n + " values: ");
        else
            System.out.println("Enter 1 value: ");

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            sum += (double) x[i];
        }

        double ave = (double) sum / n;
        double sd = 0;
        double d = 0.0;

        for (int i = 0; i < n; i++) {
            d += (double) (x[i] - ave) * (x[i] - ave);
        }

        d = (double) d / n;
        sd = Math.sqrt(d);

        System.out.printf("Mean = %.3f\n", ave);
        System.out.printf("Standard deviation = %.3f", sd);
    }
}