// QuadraticRoot class.
// Fill in the parts that are marked "WRITE YOUR CODE HERE."

import java.util.*;
import java.lang.Math;

public class QuadraticRoot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Finding the larger root of quadratic equation");
        System.out.println("Ax^2 + Bx + C = 0.");
        System.out.println("Enter coefficients A, B and C: ");
        
        // Read the three coefficients from the input.
        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        double C = scanner.nextDouble();
        
        double bigRoot = 0.0;
        
        // Call findBigRoot() method to compute the larger root of the
        // quadratic equation. 
        // If findBigRoot() throws a IllegalArgumentException, then
        // print the error message "Cannot find root.", and in the next
        // line print the message in the exception and terminate program.
                
        // =======================
        // WRITE YOUR CODE HERE.
        // =======================
        try {
            bigRoot = findBigRoot(A, B, C);
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot find root.");
            System.out.println(e);
            return;
        }
        // Print out the larger root in 3 decimal places.
        System.out.printf("The larger root is %.3f.\n", bigRoot);
       
    } // main
    
    
    
    // Compute and return the larger of the roots of the quadratic equation 
    // Ax^2 + Bx + C = 0.
    // If A == 0.0, then throw a IllegalArgumentException with the message
    // "findBigRoot(): Coefficient A is zero."
    // If discriminant < 0.0, then throw a IllegalArgumentException with the message
    // "findBigRoot(): Discriminant is negative."
    //
    // Recall that the larger of the roots is computed as
    // (-B + sqrt(discriminant)) / (2*A)
    // where discriminant = B*B - 4*A*C.
    
    public static double findBigRoot(double A, double B, double C) throws IllegalArgumentException {
        
        // =======================
        // WRITE YOUR CODE HERE.
        // =======================
        if (A == 0.0) {
            throw new IllegalArgumentException("findBigRoot(): Coefficient A is zero.");
        }

        double discriminant = B*B - 4*A*C;
        if (discriminant < 0.0) {
            throw new IllegalArgumentException("findBigRoot(): Discriminant is negative.");
        }

        return (-B + Math.sqrt(discriminant)) / (2*A);
        
    } // findBigRoot
    
    
} // class QuadraticRoot

class IllegalArgumentException extends Exception {
    String name;

    public IllegalArgumentException(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return name;
    }
}
