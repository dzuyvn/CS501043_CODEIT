// To test out CentredBall class 

// Add import statement(s) below
import java.util.*;
import java.awt.Point;

public class TestCentredBall {

	// This method reads ball's input data from user, creates
	// a ball object, and returns it to the caller.
	public static CentredBall readBall(Scanner sc) {

		System.out.print("Enter colour, radius and centre: ");
		String inputColour = sc.next();
		double inputRadius = sc.nextDouble();
		int x = sc.nextInt();
		int y = sc.nextInt();

		return new CentredBall(inputColour, inputRadius, new Point(x, y));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Read input and create 1st ball object
		System.out.println("1st ball");
		CentredBall b1 = readBall(scanner);

		// Read input and create 2nd ball object
		System.out.println("2nd ball");
		CentredBall b2 = readBall(scanner);

		// Read input and create 3rd ball object
		System.out.println("3rd ball");
		CentredBall b3 = readBall(scanner);

		System.out.println();
		if (b1.equals(b2)) {
			System.out.println("1st and 2nd balls are the same.");
		} else {
			System.out.println("1st and 2nd balls are not the same.");
		}

		CentredBall ma = b1;
		if (ma.getRadius() < b2.getRadius()) ma = b2;
		if (ma.getRadius() < b3.getRadius()) ma = b3;
		System.out.println("The largest ball created is:\n" + ma);
	}
}

//CentredBall class:
//Class attribute: quantity - number of balls created
//Instance attributes: colour, radius, centre.
class CentredBall {

	/************** Data members **********************/
	private static int quantity = 0; 

	private String colour;
	private double radius;
	private Point  centre;

	/************** Constructors **********************/
	public CentredBall() {
		this.colour = "yellow";
		this.radius = 10.0;
		this.centre = new Point(0, 0);
	}

	public CentredBall(String colour, double radius, Point centre) {
		this.colour = colour;
		this.radius = radius;
		this.centre = centre;
	}

	/**************** Accessors ***********************/
	public String getColour() {
		return this.colour;
	}
	
	public double getRadius() {
		return this.radius;
	}

	public Point getCentre() {
		return this.centre;
	}

	/**************** Mutators ************************/


	/***************** Overriding methods ******************/
	// Overriding toString() method
	public String toString() {
		return "[colour=" + this.colour + ", radius=" + this.radius + ", centre=(" + (int) this.centre.getX() + "," + (int) this.centre.getY() + ")]";
	}

	// Overriding equals() method
	public boolean equals(CentredBall obj) {
		return this.colour.equals(obj.getColour()) &&
			this.radius == obj.getRadius() &&
			this.centre.equals(obj.getCentre());
	}
}
