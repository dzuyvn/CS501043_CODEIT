// This program reads in information of a number of knobs.
// For each knob, its current state, current position and
// target position. It then computes the state of each knob after
// the required number of stops, and the total stops of all knobs.

// Add import statement(s) below
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class TurnKnobs{

	public static void main(String[] args) throws FileNotFoundException{
		HashMap<String, Integer> m = new HashMap<String, Integer>();
		m.put("up", 1);
		m.put("right", 2);
		m.put("down", 3);
		m.put("left", 4);
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("in.txt"));
		int n = sc.nextInt();
		int move = 0;
		for (int i = 0; i < n; i++) {
			String x = sc.next();
			if (x.equals("on")) {
				int a = m.get(sc.next());
				int b = m.get(sc.next());
				if (a == b) {
					move += 4;
					System.out.println("on");
				} else {
					int c = b - a;
					if (c < 0) c += 4;
					move += c;

					if (c % 2 == 1) {
						System.out.println("off");
					} else {
						System.out.println("on");
					}
				}
			} else {
				int a = m.get(x);
				int b = m.get(sc.next());
				if (a == b) {
					move += 4;
					System.out.println("off");
				} else {
					int c = b - a;
					if (c < 0) c += 4;
					move += c;

					if (c % 2 == 1) {
						System.out.println("on");
					} else {
						System.out.println("off");
					}
				}
			}
		}

		System.out.println("Total stop(s) = " + move);
	}
}

