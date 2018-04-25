// This program reads data in different formats and performs
// the respective operations.

// Add import statement(s) below

import java.util.*;

public class Reading {

	// Add a method operate(String, int, int) below

	public static void main(String[] args) {
		// Fill in the code
		Scanner sc = new Scanner(System.in);
		String t = sc.next();

		if (t.charAt(0) == 'L') {
			int n = sc.nextInt();
			while (n > 0) {
				n--;
				String op = sc.next();
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = 0;
				if (op.charAt(0) == 'A') c = a + b;
				if (op.charAt(0) == 'M') c = a * b;
				if (op.charAt(0) == 'S') c = a - b;
				System.out.println(c);
			}
		}

		if (t.charAt(0) == 'S') {
			while (true) {
				String op = sc.next();
				if (op.equals("-1")) return;

				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = 0;
				if (op.charAt(0) == 'A') c = a + b;
				if (op.charAt(0) == 'M') c = a * b;
				if (op.charAt(0) == 'S') c = a - b;
				System.out.println(c);
			}
		}

		if (t.charAt(0) == 'E') {
			while (sc.hasNext()) {
				String op = sc.next();
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = 0;
				if (op.charAt(0) == 'A') c = a + b;
				if (op.charAt(0) == 'M') c = a * b;
				if (op.charAt(0) == 'S') c = a - b;
				System.out.println(c);
			}
		}
	}
}
