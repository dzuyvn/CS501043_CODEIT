// This program reads in 4 vertices representing the opposite vertices
// of 2 rectangles and computes the overlap area of the rectangles.
// This program uses the MyRect class.

// Add import statements below
import java.awt.*;
import java.util.*;

public class OverlapRectanglesV2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter 2 opposite vertices of 1st rectangle: ");
		Point rect1Vertex1 = new Point(sc.nextInt(), sc.nextInt());
		Point rect1Vertex2 = new Point(sc.nextInt(), sc.nextInt());
		MyRect rect1 = new MyRect(rect1Vertex1, rect1Vertex2);

		System.out.print("Enter 2 opposite vertices of 2nd rectangle: ");
		Point rect2Vertex1 = new Point(sc.nextInt(), sc.nextInt());
		Point rect2Vertex2 = new Point(sc.nextInt(), sc.nextInt());
		MyRect rect2 = new MyRect(rect2Vertex1, rect2Vertex2);

		arrangeVertices(rect1);
		arrangeVertices(rect2);

   		System.out.println("1st rectangle: " + rect1);
   		System.out.println("2nd rectangle: " + rect2);

		if (rect1.equals(rect2))
			System.out.println("They are identical.");
		else
			System.out.println("They are not identical.");

		System.out.println("Overlap area = " + overlapArea(rect1, rect2));
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

	// To compute the overlap area of rectangles rect1 and rect2
	public static int overlapArea(MyRect rect1, MyRect rect2) {
		// Fill in the code 
		int x_overlap = (int) Math.max(0, Math.min(rect1.getVertex2().getX(), rect2.getVertex2().getX()) - Math.max(rect1.getVertex1().getX(), rect2.getVertex1().getX()));
		int y_overlap = (int) Math.max(0, Math.min(rect1.getVertex2().getY(), rect2.getVertex2().getY()) - Math.max(rect1.getVertex1().getY(), rect2.getVertex1().getY()));
		return x_overlap * y_overlap;
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
