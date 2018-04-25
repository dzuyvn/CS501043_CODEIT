import java.util.*;

public class SumIntegers {
    public static void main(String[] args) {
        int i = 1, sum = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scan.nextInt();
        while (i <= n) sum += i++;
        System.out.println("Sum = " + sum);
    }
}