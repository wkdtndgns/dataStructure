package hw;

public class oddSort {


	static int Solution(int a[]){

	
		int x = a[0];
		
		for(int i=1; i<a.length; i++){
			
			x= x^a[i];
		}
		
		return x;
	}



	public static void main(String[] args) {

		int[] a = {3,9,3,9,9,7,9};


		System.out.println(Solution(a)); 

	}



}
