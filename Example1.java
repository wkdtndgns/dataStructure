package hw;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class Example1 {

	static Random random = new Random();

	static String[] createRadomStringArray(int size) {
		String[] a = new String[size];
		for (int i = 0; i < size; ++i) {
			int value = random.nextInt(10);
			String s = String.format("%02d", value);
			a[i] = s;
		}
		return a;        
	}

	static void printCollection( Collection<String> c) {
		String[] a = c.toArray(new String[0]);
		Arrays.sort(a);
		System.out.printf("%s\n",Arrays.toString(a));
	}


	public static void main(String[] args) {
		String[] a1 = createRadomStringArray(12);
		String[] a2 = createRadomStringArray(8);
		String[] a3 = createRadomStringArray(6);

		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		System.out.println(Arrays.toString(a3));

		// 구현시작


		Collection<String> c1 = new ArrayList<String>();
		Collection<String> c2 = new ArrayList<String>();
		Collection<String> c3 = new ArrayList<String>();
		Collection<String> c4 = new ArrayList<String>();

		for(int i=0; i<a1.length; i++)
			c1.add(a1[i]);

		for(int i=0; i<a2.length; i++)
			c2.add(a2[i]);

		for(int i=0; i<a3.length; i++)
			c3.add(a3[i]);




		c4.addAll(c1);
		
		c4.retainAll(c2);
		
		c4.removeAll(c3);


		printCollection(c4);


	}

}
