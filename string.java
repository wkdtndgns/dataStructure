package lecture;

import java.lang.reflect.Array;

public class string {

	public static void main(String[] args ){

		String s ="hello world\n";
		String t ="Hello World\n";
		String[] a = s.split(" ");
		String b = "b";
		Object w= "hello";

		for (int i=0; i< s.length(); ++i)
			System.out.printf("%c", s.charAt(i));

		System.out.println(s.compareTo(t));
		System.out.println(s.compareToIgnoreCase(t)==0);

		System.out.println(s.contains("hello "));
		System.out.println(s.endsWith("rld\n"));
		System.out.println(s.equals(t )== false);
		System.out.println(s.equalsIgnoreCase(t));
		System.out.println(s.isEmpty()==false);
		System.out.println(s.indexOf("o")==4);
		System.out.println(s.lastIndexOf("o")==7);
		System.out.println(s.length()==12);
		System.out.println(s.startsWith("hel"));


		System.out.println(a.length==2);
		System.out.println(a[0].equals("hello"));

		System.out.println(s.substring(0, 5).equals("hello"));
		System.out.println(t.toLowerCase().equals(s));

		System.out.println(s);

		
		int q1=1;
		int q2=2;
		int q3=3;
		
		System.out.println(q1==1?q2==3 :q3==3); 

	}


}
