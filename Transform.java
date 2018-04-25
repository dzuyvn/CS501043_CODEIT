import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Transform {
	private static int[][] matrix;
	private static int size;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("in.txt"));
		size = sc.nextInt();
		matrix = new int[size + 1][size + 1];

		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				matrix[r][c] = sc.nextInt();
			}
		}

		int operations = sc.nextInt();
		for (int i = 0; i < operations; i++) {
			String operation = sc.next();
			String type = sc.next();

			if (operation.equals("Rotate")) {
				if (type.charAt(0) == '9') rotate(90);
				if (type.charAt(0) == '1') rotate(180);
				if (type.charAt(0) == '2') rotate(270);
				//rotate(Integer.parseInt(type));
			}
			
			if (operation.equals("Reflect")) {
				if (type.equals("x")) reflectX();
				if (type.equals("y")) reflectY();
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) 
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}

	private static void rotate(int degree) {
		int[][] mat = new int[size + 1][size + 1];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				if (degree == 90)
					mat[j][size - i - 1] = matrix[i][j];
				if (degree == 180)
					mat[size - i - 1][size - j - 1] = matrix[i][j];
				if (degree == 270)
					mat[size - j - 1][i] = matrix[i][j];
			}
		matrix = mat;
	}

	private static void reflectX() {
		for (int i = 0, k = size - 1; i < k; i++, k--) {
			int[] x = matrix[i];
			matrix[i] = matrix[k];
			matrix[k] = x;
		}
	}

	private static void reflectY() {
		for (int i = 0, k = size - 1; i < k; i++, k--) {
			for  (int j = 0; j < size; j++) {
				int x = matrix[j][i];
				matrix[j][i] = matrix[j][k];
				matrix[j][k] = x;
			}
		}
	}
}