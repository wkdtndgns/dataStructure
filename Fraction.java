package lecture;

class Fraction {


	private int numerator;
	private int denominator;



	Fraction(int numerator , int denominator){
		int god = greatestCommonDivisor(numerator, denominator);
		this.numerator =numerator/god;
		this.denominator = denominator /god; 

	}


	@Override
	public String toString(){
		return numerator+ "  " +denominator ;		
	}

	@Override 
	public boolean equals(Object obj){
		if((obj instanceof Object)==false) 
			return false;
		Fraction f =(Fraction)obj;
		return this.numerator ==f.numerator &&this.denominator == f.denominator;


	}


	public static Fraction add(Fraction f1 ,Fraction f2){
		int numerator = (f1.numerator*f2.denominator)+(f2.numerator*f1.denominator);
		int denominator = (f1.denominator*f2.denominator);		

		return new Fraction(numerator , denominator);		

	}

	public static int greatestCommonDivisor(int x , int y){
		return y==0 ? x:greatestCommonDivisor(y,x%y);

	}	


}
	

	

