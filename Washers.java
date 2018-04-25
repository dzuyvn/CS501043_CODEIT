import java.util.*;
import java.lang.*;

public class Washers {
    public static double circle_area(double diameter) {
        return Math.pow(diameter/2, 2) * Math.PI;
    }

    public static void main(String[] args) {
        double d1, d2, thickness, density;
        int qty;
        double unit_weight, total_weight, rim_area;

        Scanner sc = new Scanner(System.in);
        System.out.printf("Inner diameter in cm: ");
        d1 = sc.nextDouble();
        System.out.printf("Outer diameter in cm: ");
        d2 = sc.nextDouble();
        System.out.printf("Thickness in cm: ");
        thickness = sc.nextDouble();
        System.out.printf("Density in grams per cubic cm: ");
        density = sc.nextDouble();
        System.out.printf("Quantity: ");
        qty = sc.nextInt();

        rim_area = circle_area(d2) - circle_area(d1);
        unit_weight = rim_area * thickness * density;
        total_weight = unit_weight * qty;
        
        System.out.printf("Total weight of %d washers is %.2f grams.\n", qty, total_weight);
    }
}