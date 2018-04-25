// To test out the Fraction class
// This program is not to be modified.
import java.util.*;

public class TestFraction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter 1st fraction: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		Fraction f1 = new Fraction(a, b);

		System.out.print("Enter 2nd fraction: ");
		a = sc.nextInt();
		b = sc.nextInt();
		Fraction f2 = new Fraction(a, b);

		System.out.println();
		System.out.println("1st fraction is " + f1);
		System.out.println("2nd fraction is " + f2);

		if (f1.simplify().equals(f2.simplify())) 
			System.out.println("The fractions are the same.");
		else
			System.out.println("The fractions are not the same.");

		Fraction sum = f1.add(f2);
		System.out.println("Sum is " + sum);
	}
} 

//Fraction class

class Fraction {

	/************** Data members **********************/
	private int numer;
	private int denom;

	/************** Constructors **********************/
	public Fraction() {
		this.numer = 1;
		this.denom = 1;
	}

	public Fraction(int numer, int denom) {
		this.numer = numer;
		this.denom = denom;
	}

	/**************** Accessors ***********************/
	public Fraction add(Fraction f) {
		Fraction r = new Fraction(this.numer * f.denom + this.denom * f.numer, this.denom * f.denom);
		return r.simplify();
	}

	/**************** Mutators ************************/
	public int getNumer() {
		return this.numer;
	}

	public int getDenom() {
		return this.denom;
	}

	/***************** Other methods ******************/
	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public boolean equals(Fraction f) {
		return this.numer == f.getNumer() && this.denom == f.getDenom();
	}

	public Fraction simplify() {
		int c = gcd(this.denom, this.numer);
		//if (this.numer > 0 && this.denom < 0) {
		//	this.numer *= -1;
		//	this.denom *= -1;
		//}

		return new Fraction(this.numer/c, this.denom/c);
	}
	
    @Override
    public String toString() {
		//if (this.getNumer() == 0) return "0";
        return this.getNumer() + "/" + this.getDenom();
    }
}