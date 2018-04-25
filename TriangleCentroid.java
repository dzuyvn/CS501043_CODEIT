import java.util.*;

public class TriangleCentroid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 vertices: ");
        double x = 0.0, y = 0.0;
        for (int i = 0; i < 3; i++) {
            x += (double) sc.nextInt();
            y += (double) sc.nextInt();
        }

        x = (double) x / 3;
        y = (double) y / 3;

        System.out.println("Centroid at Point2D.Double[" + x + ", " + y + "]");
    }
}