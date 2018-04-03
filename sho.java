package lecture;

public class sho {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Fraction f1 =new Fraction(1,2);
		Fraction f2 =new Fraction(1,3);

		System.out.printf("%s + %s =%2s\n",f1,f2,Fraction.add(f1, f2));
		System.out.printf("%s - %s =%2s\n",f1,f2,Fraction.add(f1, f2));
		System.out.printf("%s * %s =%2s\n",f1,f2,Fraction.add(f1, f2));
		System.out.printf("%s / %s =%2s\n",f1,f2,Fraction.add(f1, f2));

		System.out.println(Fraction.add(f1, f2).equals(new Fraction(5,6)));


	}

}
