// To test out CentredCircle class 
// This class is given and should not be modified.
// Aaron Tan

import java.util.*;

public class TestCentredCircle {

	// This method reads circle's input data from user, creates
	// a CentredCircle object, and returns it to the caller.
	public static CentredCircle readCircle(Scanner sc) {

		System.out.print("Enter colour: ");
		String inputColour = sc.next();

		if (inputColour.equals("Default"))
			return new CentredCircle();
		else {
			System.out.print("Enter radius: ");
			double inputRadius = sc.nextDouble();
			System.out.print("Enter centre: ");
			double inputCentreX = sc.nextDouble();
			double inputCentreY = sc.nextDouble();

			// Create a CentredCircle object using the alternative constructor
			return new CentredCircle(inputColour, inputRadius, 
		                             new POINT2D(inputCentreX, inputCentreY));
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Read input and create a CentredCircle object
		CentredCircle circle1 = readCircle(scanner);
		System.out.println();

		// Read input and create another CentredCircle object
		CentredCircle circle2 = readCircle(scanner);
		System.out.println();

		// Testing toString() method in CentredCircle class
		// You may also write: 
		//    System.out.println("1st circle: " + circle1.toString());
		//    System.out.println("2nd circle: " + circle2.toString());
		System.out.println("1st circle: " + circle1);
		System.out.println("2nd circle: " + circle2);

		// Testing equals() method in CentredCircle class
		if (circle1.equals(circle2))
			System.out.println("They are identical.");
		else
			System.out.println("They are not identical.");
	}
}
//CentredCircle class:
//Subclass of Circle
//Instance attribute: centre
class POINT2D {
	public double x;
	public double y;

	public POINT2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(POINT2D o) {
		return this.x == o.x && this.y == o.y;
	}
}
class CentredCircle extends Circle {

	/************** Data members **********************/
	protected POINT2D centre;

	/************** Constructors **********************/
	// Default constructor creates a yellow circle 
	// with radius 10.0 circle and centre at (0,0)

	public CentredCircle() {
		// Fill in the code
		super("yellow", 10.0);
		centre = new POINT2D(0, 0);
	}

	public CentredCircle(String colour, double radius, POINT2D centre) {
		// Fill in the code
		super(colour, radius);
		this.centre = centre;
	}

	/**************** Accessor ***********************/
	public POINT2D getCentre() {
		// Fill in the code
		return this.centre;
	}

	/**************** Mutator ************************/
	public void setCentre(POINT2D centre) {
		// Fill in the code
		this.centre = centre;
	}

	/***************** Overriding methods ******************/
	// Overriding toString() method
	@Override
	public String toString() {
		// Fill in the code
		return "[" + getColour() + ", " + getRadius() + ", (" + centre.x + "," + centre.y + ")]";
	}

	// Overriding equals() method
	public boolean equals(Object obj) {
		// Fill in the code
		if (obj instanceof CentredCircle) {
			CentredCircle circle = (CentredCircle) obj;
			return this.getColour().equals(circle.getColour()) &&
				   this.getRadius() == circle.getRadius() &&
				   this.centre.equals(circle.getCentre());
		}
		else
			return false;
	}
}

//Circle class:
//Instance attributes: colour, radius
//This class is given and should not be modified.
//Aaron Tan

class Circle {

	/************** Data members **********************/
	protected String colour;
	protected double radius;

	/************** Constructors **********************/
	// Default constructor creates a yellow, radius 10.0 circle

	public Circle() {
		this("yellow", 10.0);
	}

	public Circle(String colour, double radius) {
		setColour(colour);
		setRadius(radius);
	}

	/**************** Accessors ***********************/
	public String getColour() {
		return this.colour;   // 'this' is optional here
	}

	public double getRadius() {
		return this.radius;   // 'this is optional here
	}

	/**************** Mutators ************************/
	public void setColour(String colour) {
		this.colour = colour;  // 'this' is required here
	}

	public void setRadius(double radius) {
		this.radius = radius;  // 'this' is required here
	}

	/***************** Overriding methods ******************/
	// Overriding toString() method
	public String toString() {
		return "[" + getColour() + ", " + getRadius() + "]";
	}

	// Overriding equals() method
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle circle = (Circle) obj;
			return this.getColour().equals(circle.getColour()) &&
			       this.getRadius() == circle.getRadius();
		}
		else
			return false;
	}
}

