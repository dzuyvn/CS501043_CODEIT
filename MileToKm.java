import java.util.Scanner;

public class MileToKm {
    public static final double KMS_PER_MILE = 1.609;
    public static void main(String[] args) {
        System.out.print("Enter distance in miles: ");
        Scanner sc = new Scanner(System.in);
        double miles = sc.nextDouble();
        double kms = KMS_PER_MILE * miles;
        System.out.printf("That equals %9.2f km.\n", kms);
    }
}