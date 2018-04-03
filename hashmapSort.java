package hw;
import java.util.HashMap;
public class hashmapSort {

	static int Solution(int a[]){

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i =0; i<a.length ; i++)
		{
			if (map.containsKey(a[i])) {		//  맵안에 키값이 있을 경우 	
				int count = map.get(a[i]);		//  get a[i] 의  해쉬 값을 count에 저장 
				map.put(a[i], count + 1); 		//  다시 맵에 a[i] 의 해쉬값 count +1을 저장 
			}
			else		 // 아닐 경우 	
				map.put(a[i],0);	// 맵에 a[i] 해쉬값 0 저장 
		}

	
		
		for (int i : map.keySet()) {	//  map에 있는 key 값까지
			
			int count= map.get(i);	 // get i 의  해쉬 값을 count에 저장 
			if(count%2==0)
				return i;
			
		}



		return -1;

	}

	public static void main(String[] args) {

		int[] a = {3,9,3,9,9,7,9};



		System.out.println(Solution(a)); 

	}
}
