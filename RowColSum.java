import java.*;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;;

public class RowColSum {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(new FileInputStream("in.txt"));
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of rows and columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[] rs = new int[r];
        int[] rc = new int[c];

        System.out.println("Enter values for 2D array: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int x = sc.nextInt();
                rs[i] += x;
                rc[j] += x;
            }
        }

        System.out.print("Row sums: ");
        printArr(rs, r);
        System.out.print("Column sums: ");
        printArr(rc, c);
    }

    public static void printArr(int[] s, int k) {
		System.out.print("[" + s[0]);
		for (int i = 1; i < k; i++)
			System.out.print(", " + s[i]);
		System.out.println("]");
	}
}