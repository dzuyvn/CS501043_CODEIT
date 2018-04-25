public class FractionArr implements FractionI {

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
		return new FractionArr(this.getNumer() / c, this.getDenom() / c);
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
