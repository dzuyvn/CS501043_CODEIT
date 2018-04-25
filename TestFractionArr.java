// To test out FractionArr class
import java.util.*;

public class TestFractionArr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter 1st fraction: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		FractionI f1 = new FractionArr(a, b);

		System.out.print("Enter 2nd fraction: ");
		a = sc.nextInt();
		b = sc.nextInt();
		FractionI f2 = new FractionArr(a, b);

		System.out.println("1st fraction is " + f1);
		System.out.println("2nd fraction is " + f2);

		if (f1.equals(f2)) 
			System.out.println("The fractions are the same.");
		else
			System.out.println("The fractions are not the same.");

		FractionI sum = f1.add(f2);
		System.out.println("Sum is " + sum);

		FractionI diff = f1.minus(f2);
		System.out.println("Difference is " + diff);

		FractionI prod = f1.times(f2);
		System.out.println("Product is " + prod);

		FractionI quoI = f1.divide(f2);
		if (quoI.getDenom() != 0) System.out.println("Quotient is " + quoI);
		else System.out.println("Division by zero error!");
	}
} 

interface FractionI { 
	public int getNumer();   // returns numerator part
	public int getDenom();   // returns denominator part
	public void setNumer(int numer);   // sets new numerator
	public void setDenom(int denom);   // sets new denominator

	public FractionI add(FractionI f);     // returns this + f
	public FractionI minus(FractionI f);   // returns this - f
	public FractionI times(FractionI f);   // returns this * f
	public FractionI divide(FractionI f);  // returns this / f
	public FractionI simplify();           // simplifies this
}

class FractionArr implements FractionI {

	/************** Data members **********************/
	private int[] members;

	/************** Constructors **********************/
    // Default constructor creates a fraction 1/1
	public FractionArr() {
		this.members = new int[2];
		this.members[0] = 1;
		this.members[1] = 1;
	}

	public FractionArr(int a, int b) {
		this.members = new int[2];
		this.members[0] = a;
		this.members[1] = b;
	}

    /**************** Accessors ***********************/
    @Override
	public int getNumer() {
		return this.members[0];
	}

    @Override
	public int getDenom() {
		return this.members[1];
	}

    @Override
	public void setNumer(int numer) {
		this.members[0] = numer;
	}

    @Override
	public void setDenom(int denom) {
		this.members[1] = denom;
	}

	/**************** Mutators ************************/
    @Override
    public FractionI add(FractionI f) {
		FractionArr r = new FractionArr();
		r.setNumer(this.getNumer() * f.getDenom() + f.getNumer() * this.getDenom());
		r.setDenom(this.getDenom() * f.getDenom());
		return r.simplify();
	}

    @Override
	public FractionI minus(FractionI f) {
		FractionArr r = new FractionArr();
		r.setNumer(this.getNumer() * f.getDenom() - f.getNumer() * this.getDenom());
		r.setDenom(this.getDenom() * f.getDenom());
		return r.simplify();
	}

    @Override
	public FractionI times(FractionI f) {
		FractionArr r = new FractionArr();
		r.setNumer(this.getNumer() * f.getNumer());
		r.setDenom(this.getDenom() * f.getDenom());
		return r.simplify();
	}
    
    @Override
	public FractionI divide(FractionI f) {
		FractionArr r = new FractionArr();
		try {
			r.setNumer(this.getNumer() * f.getDenom());
			r.setDenom(this.getDenom() * f.getNumer());
			return r.simplify();
		} catch (ArithmeticException e) {
			System.out.println("Division by zero error!");
		}
		return r.simplify();
	}

    @Override
	public FractionI simplify() {
		int c = gcd(this.getNumer(), this.getDenom());
		int a = this.getNumer() / c;
		int b = this.getDenom() / c;
		if (b < 0) {
			b *= -1;
			a *= -1;
		}
		return new FractionArr(a, b);
	}
	/***************** Other methods ******************/

    @Override
    public String toString() {
        return this.getNumer() + "/" + this.getDenom();
    }
    
	public int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

}
