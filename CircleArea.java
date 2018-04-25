import java.util.Scanner;
import java.lang.Math;

public class CircleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side of square: ");
        double side = sc.nextDouble();
        double d = Math.sqrt(side * side + side * side);
        d = (double) d/2;
        System.out.printf("Area of circle = %.2f", Math.PI * d * d);
    }
}