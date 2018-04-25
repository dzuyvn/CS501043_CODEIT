// This program reads in a number of rectangles and compute the
// overlap of all rectangles.
// This program uses the MyRect class.

// Add import statements below
import java.awt.*;
import java.util.*;

public class OverlapRectanglesV3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyRect rect1, rect2;

		System.out.print("How many rectangles? ");
		int numRect = sc.nextInt();

		System.out.print("Enter 2 opposite vertices of first rectangle: ");
		rect1 = readRectangle(sc);
		arrangeVertices(rect1);

		boolean f = false;
		for (int i=2; i<=numRect; i++) {
			System.out.print("Enter 2 opposite vertices of next rectangle: ");
			rect2 = readRectangle(sc);
			arrangeVertices(rect2);
			try {
				rect1 = overlap(rect1, rect2);
			} catch (Fail e) {
				f = true;
			}
		}

		int overlapArea = area(rect1);
		if (overlapArea == 0 || f == true)
			System.out.println("No overlap");
		else {
			System.out.println("Overlap rectangle: " + rect1);
			System.out.println("Overlap area = " + overlapArea);
		}
	}

	// Read data of a rectangle, create a rectangle object
	// and return it.
	public static MyRect readRectangle(Scanner sc) {
		Point vertex1 = new Point(sc.nextInt(), sc.nextInt());
		Point vertex2 = new Point(sc.nextInt(), sc.nextInt());
		return new MyRect(vertex1, vertex2);
	}

	// To rearrange the 2 opposite vertices of rect
	// such that the first vertex v1 becomes the bottom-left vertex
	// and the second vertex v2 becomes the top-right vertex.
	public static void arrangeVertices(MyRect rect) {
		// Fill in the code
		int x_min = Math.min((int) rect.getVertex1().getX(), (int) rect.getVertex2().getX());
		int y_min = Math.min((int) rect.getVertex1().getY(), (int) rect.getVertex2().getY());
		int x_max = Math.max((int) rect.getVertex1().getX(), (int) rect.getVertex2().getX());
		int y_max = Math.max((int) rect.getVertex1().getY(), (int) rect.getVertex2().getY());

		rect.setVertex1(new Point(x_min, y_min));
		rect.setVertex2(new Point(x_max, y_max));
	}

	// To compute the overlap rectangle of rect1 and rect2
	public static MyRect overlap(MyRect rect1, MyRect rect2) throws Fail {
		// Fill in the code
		int x_min = (int) Math.max(rect1.getVertex1().getX(), rect2.getVertex1().getX());
		int y_min = (int) Math.max(rect1.getVertex1().getY(), rect2.getVertex1().getY()); 
		int x_max = (int) Math.min(rect1.getVertex2().getX(), rect2.getVertex2().getX());
		int y_max = (int) Math.min(rect1.getVertex2().getY(), rect2.getVertex2().getY());

		if (x_min > x_max || y_min > y_max)
			throw new Fail("No overlap"); 

		return new MyRect(new Point(x_min, y_min), new Point(x_max, y_max));
	}

	// To compute the area of rect
	public static int area(MyRect rect) {
		// Fill in the code
		return (int) (rect.getVertex2().getX() - rect.getVertex1().getX()) * (int) (rect.getVertex2().getY() - rect.getVertex1().getY()); 
	}
}

class Fail extends Exception {
	String s;
	public Fail(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return s;
	}
}

class MyRect {

	/************** Data members **********************/
	private Point vertex1, vertex2;

	/************** Constructors **********************/

	public MyRect() {
		this(0, 0, 1, 1); //Default rectangle with vertices (0,0) and (1,1)
	}

	public MyRect(Point v1, Point v2) {
		setVertex1(new Point(v1));
		setVertex2(new Point(v2));
	}

	public MyRect(int v1X, int v1Y, int v2X, int v2Y) {
		setVertex1(new Point(v1X, v1Y));
		setVertex2(new Point(v2X, v2Y));
	}

	/**************** Accessors ***********************/
	public Point getVertex1() {
		// fill in the code
		return this.vertex1;
	}

	public Point getVertex2() {
		// fill in the code
		return this.vertex2;
	}

	/**************** Mutators ************************/
	public void setVertex1(Point pt) {
		// fill in the code
		this.vertex1 = pt;
	}

	public void setVertex2(Point pt) {
		// fill in the code
		this.vertex2 = pt;
	}

	/***************** Overriding methods ******************/
	// Overriding toString() method
	public String toString() {
		// fill in the code
		return "[(" + (int) vertex1.getX() + ", " + (int) vertex1.getY() + "); (" + (int) vertex2.getX() + ", " + (int) vertex2.getY() + ")]";
	}

	// Overriding equals() method
	public boolean equals(Object obj) {
		// fill in the code
		MyRect v = (MyRect) obj;
		return this.vertex1.equals(v.vertex1) && this.vertex2.equals(v.vertex2);
	}
}
