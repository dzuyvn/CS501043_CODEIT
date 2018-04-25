// To compute the distance of the nearest pair of points
// among a list of points.

import java.util.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class NearestPoints {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("in.txt"));

		double minDist;

		int size = sc.nextInt();  // size of list;

		ArrayList<Point> points = new ArrayList<Point>(size);
		minDist = 100000000000.0;
		
		for (int i = 0; i < size; i++) {
			points.add(new Point(sc.nextInt(), sc.nextInt()));
			for (int j = 0; j < i; j++) {
				Point a = points.get(j);
				Point b = points.get(i);
				double dist = a.distance(b);
				if (dist < minDist) 
					minDist = dist;
			}
		}

		
		System.out.printf("Minimum distance = %.2f\n", minDist);
	}
}

