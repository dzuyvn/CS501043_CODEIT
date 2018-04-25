// This program reads two sets of integers A and B, and determines
// if A is a subset of B, and if A is same as B.
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class TestSet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of elements in set A: ");
		int n = sc.nextInt();
		int[] a = new int[n];
		System.out.print("Enter elements for set A: ");
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();

		System.out.print("Enter number of elements in set B: ");
		int m = sc.nextInt();
		int[] b = new int[m];
		System.out.print("Enter elements for set B: ");
		for (int i = 0; i < m; i++)
			b[i] = sc.nextInt();

		System.out.print("Set A: ");
		printSet(a, n);
		System.out.print("Set B: ");
		printSet(b, m);

		Arrays.sort(a);
		Arrays.sort(b);

		boolean isSubset = true;
		for (int i = 0; i < n; i++) {
			boolean f = false;
			for (int j = 0; j < m; j++) 
				if (b[j] == a[i]) {
					f = true;
					break;
				}
			if (f == false) {
				isSubset = false;
				break;
			}
		}

		if (isSubset) {
			System.out.println("Set A is a subset of set B.");
		} else {
			System.out.println("Set A is not a subset of set B.");
		}

		boolean isEqual = (m == n);
		if (m == n) {
			for (int i = 0; i < n; i++)
				if (a[i] != b[i]) {
					isEqual = false;
					break;
				}
		}

		if (isEqual) {
			System.out.println("Set A is equal to set B.");
		} else {
			System.out.println("Set A is not equal to set B.");
		}
	}

	public static void printSet(int[] s, int k) {
		System.out.print("[" + s[0]);
		for (int i = 1; i < k; i++)
			System.out.print(", " + s[i]);
		System.out.println("]");
	}
} 