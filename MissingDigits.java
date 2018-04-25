import java.util.Scanner;
import java.util.Vector;;

public class MissingDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        Vector<Integer> d = new Vector<Integer>();
        
        int m = n;
        while (n > 0) {
            d.add(n % 10);
            n /= 10;
        }

        System.out.print("Missing digits in " + m + ": ");
        for (int i = 0; i < 10; i++)
            if (d.contains(i) == false)
                System.out.print(i + " ");
    }
}