public interface FractionI { 
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
