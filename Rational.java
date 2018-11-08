/**
 * @author Griffin Smith
 * Rational.java
 * Project 4
 * The code contained in this class is used to create an object containing a rational number
 * and manipulate the rational number using data encapsulation techniques and various methods;
 */
public class Rational {
private long numer; 
private long denom;

	public Rational() {
		//a is the numerator
		//b is the denominator 
		this.numer = 0;
		this.denom = 1;
		
	}
	
	public Rational(long a) {
		this.numer = a;
		this.denom = 1;
	}
	
	public Rational(long a, long b) {
		this.numer = a;
		this.denom = b;
		
		if (denom == 0) 
		{
			throw new ArithmeticException("Cannot divide by 0!");
		}
		
		//The next two if statements ensure that the denominator will never be negative.
		if (b < 0) {
			b = -b;
			a = -a;
		}
		if (a < 0 && b < 0) {
			a = -a;
			b = -b;
		}
	}
	
	
	//Start of the mathematical operations
	
	//Adds a rational to THIS rational and simplifies it while also handling a null parameter;
	public Rational add(Rational r) {
		if (r != null) {
		long a = r.getNumerator();
		long b = r.getDenominator();
		//Getting common denominator and adding the numerators;
		numer = (numer * b) + (a * denom);
		denom = denom * b;
		
		simplify(numer, denom);
		//Remove after testing
		System.out.println(a + " " + b + "\n The simplified rational is " + numer + "/" + denom );
		System.out.println("The numerator is " + numer + "the denominator is " + denom);
		makePositive(r);
		return r;
		}
		else 
		{
			return null;
		}
		
	}
	//This method subtracts Rational r from THIS Rational while also handling a null parameter;
	public Rational subtract(Rational r) {
		if (r != null) {
			long a = r.getNumerator();
			long b = r.getDenominator();
			//Getting common denominator and adding the numerators;
			numer = (numer * b) - (a * denom);
			denom = denom * b;
			
			simplify(numer, denom);
			//Remove after testing
			System.out.println(a + " " + b + "\n The simplified rational is " + numer + "/" + denom );
			System.out.println("The numerator is " + numer + "the denominator is " + denom);
			makePositive(r);
			return r;
			}
			else 
			{
				return null;
			}
			
	}
	
	public Rational multiply(Rational r) {
		if (r != null) {
			long a = r.getNumerator();
			long b = r.getDenominator();
			System.out.println("The numerator of r is " + a + "\n The denominator of r is " + b);
			System.out.println("The current value of THIS is " + numer + "/" + denom);
			//Multiplying the numerator by the other numerator and the denominator by the other denominator;
			numer = numer * a;
			denom = denom * b;
			
			//gets the gcd of numerator and denominator
			long gcd = gcd(numer, denom) ;
			
			numer = numer/gcd;
			denom = denom/gcd;
			makePositive(r);
			System.out.println("The simplified rational is " + numer + "/" + denom);
			return r;
			
		}
		else {
			
			return null;
		}
	}
	
	//This method divides THIS by r while also handling an input of null; It implements this by multiplying by the reciprocal or r;
	public Rational divide(Rational r) {
		if (r != null) {
			long a = r.getDenominator();
			long b = r.getNumerator();
			System.out.println("The numerator of r is " + a + "\n The denominator of r is " + b);
			System.out.println("The current value of THIS is " + numer + "/" + denom);
			//Multiplying the numerator by the other numerator and the denominator by the other denominator;
			numer = numer * a;
			denom = denom * b;
			
			//gets the gcd of numerator and denominator
			long gcd = gcd(numer, denom) ;
			
			numer = numer/gcd;
			denom = denom/gcd;
			makePositive(r);
			System.out.println("The simplified rational is " + numer + "/" + denom);
			return r;
			
		}
		else {
			
			return null;
		}
	}
	
	
	
	
	//method for simplifying the numerator and denominator;
	public void simplify(long a, long b) {
		
		this.numer = (a/gcd(a,b));
		this.denom = (b/gcd(a,b));
	
	}
	
	//This method can be called to ensure that the denominator is never negative before you return a value;
	public void makePositive(Rational r) {
		
		if (denom < 0) {
			this.numer = -numer;
			this.denom = -denom;
		}
		
	}
	

	
	//Finds the gcd of two numbers using the Euclidean Algorithm;
	public long gcd(long p, long q) {
		
		//Converts the two values to positive for easier implementation;
		if (p < 0) {
			p = -p;
		}
		if (q < 0) {
			q = -q;
		}
		
		long remainder;
		long gcd;
		if (p < q)
		{
			//swaps variables if p is less than q;
			long temp = p;
			p = q;
			q = temp;
			
			//algorithm for calculating the gcd;
			do 
			{	
				// calculates initial remainder and checks to see if it is zero;
				remainder = p % q; 
				if (remainder == 0) {
					gcd = q;
					return gcd;
				}
				//Moves the denominator to the numerator, and sets the denominator equal to the last remainder calculated;
				p = q;
				q = remainder;
			} while(remainder != 0);
			
		} 
		else 
		{
			//algorithm for calculating the gcd if p is not less than q
			do 
			{
				remainder = p % q; // = remainder
				if (remainder == 0) {
					gcd = q;
					return gcd;
				}
				p = q;
				q = remainder;
			} while(remainder != 0);
		}
		
		return -1;
		
	}
	
	
		//Accessors to get the current value of numerator and denominator;
		public long getNumerator() {
			return this.numer;
		}
		
		public long getDenominator() {
			return this.denom;
		}
		
	
	
	
}
