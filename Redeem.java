// This program reads in an item's cost and some coupons' information,
// and then determines which is the best coupon to use and the amount 
// to pay.
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
// Add import statement(s) below


public class Redeem {

	public static void main(String[] args) /*throws IOException*/ {
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("in.txt"));
		double amount = sc.nextDouble();
		int n = sc.nextInt();

		boolean f = false;
		Coupon mi = new Coupon();

		for (int i = 0; i < n; i++) {
			Coupon cp = new Coupon(sc.next(), sc.nextDouble());
			//System.out.println(cp.getName() + "  " + cp.payment(amount));
			if (cp.payment(amount) == 0) {
				mi = cp;
				break;
			}

			if (!f) {
				mi = cp;
				f = true;
				continue;
			}

			double a = cp.payment(amount);
			double b = mi.payment(amount);

			if (a < 0 && b > 0) {
				mi = cp;
				continue;
			}

			if (a > 0 && b < 0) {
				continue;
			}

			if (a < 0 && b < 0) {
				if (a > b) mi = cp;
				continue;
			}

			if (a > 0 && b > 0) {
				if (a < b) mi = cp;
				continue;
			}
		}

		// Output the result
		// Ensure your output is in the right format
		double res = mi.payment(amount);
		if (res < 0) res = 0;
		System.out.println("Best choice: " + mi.getName());
		System.out.printf("You need to pay $%.2f\n", res);
	}
}

//Define a coupon with rate
//rate > 1: cash coupon with face value = rate
//rate < 1: discount coupon with rate of discount
class Coupon {

	/********* Data attributes **********/
	private String name;
	private double rate;

	/********** Constructors **********/
	public Coupon(){        
	}

	public Coupon(String name, double rate) {
		// fill in the code
		this.name = name;
		this.rate = rate;
	}

	/********* Accessors ************/
	public String getName() {
		return name;
	}

	public double getRate() {
		return rate;
	}

	// Computes the amount to pay.
	// If payment calculated is negative, it means that
	// the coupon's value is larger than the price.
	public double payment(double price) {
		// fill in the code
		if (rate >= 1) {
			return price - rate;
		} else {
			return (double) price * (1 - rate);
		}
	}
}
