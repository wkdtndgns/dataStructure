package hw;

import java.util.Arrays;

public class sortArray {

	static int Solution(int a[]){

		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		
		int count=0;
		int temp=0; 
		
		for(int i=0; i<a.length; i++){
			
			if(a[i]==a[i+1]){
				count++;
			}
			
			else if(count%2==0){
				count=0;
				return a[i];				
			}
			else 
				count=0;
		
		}

		
		return -1; 
	}

	public static void main(String[] args) {

		int[] a = {3,9,9,9,7,9};


		System.out.println(Solution(a)); 
		
	}




}
