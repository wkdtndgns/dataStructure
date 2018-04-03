package hw;

import java.util.HashMap;

import hw.Example3.Node;

public class OddOccurences {
	
	static int Solution(int a[]){
 
		HashMap<Integer,Integer> map =new HashMap < Integer, Integer>();
		for (int i=0; i<a.length; i++){
			int key=a[i];
			Integer count = map.get(key);
			if(count==null) count = 1; 
			else count = count +1 ;
			map.put(key,count);
		}
		
		for(Integer key : map.keySet()){
			Integer count = map.get(key);
			if(count %2 == 1 ) return key;
			
		}
		
		//int a =? ;  int b = a^ a ;  b는 0 
		//  a^c^a  ==c  둘이 동일  0 ^c= c    a가 짝수번 ㄷ등장하기 때문에     
		
		return 0;
		
		
}
	
	
	
	  public static void main(String[] args) {
		  
		int[] a = new int [4];
		  
		  for (int i=0; i<a.length; i++){
			  a[i]= i+3;			  
		  }
		  
	      int b= a[2]^ a[0];
	      System.out.println(b);
		  
	    }

}
