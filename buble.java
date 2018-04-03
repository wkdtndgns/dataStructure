package lec;

public class buble {
	public static void main(String[] args) {

		int[] a = new int[]{30,50,20,70,10,90,80,60};

		for(int s : a){
			System.out.print(s+" ");
		}
		
		System.out.println();

		for(int i= a.length-1; i >0; i--){
			for(int j=0; j<i; j++){
				if(a[j]>a[j+1]){
					int temp = 0;
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					
				}
					
				
			}
			
			
		}
		
		for(int s : a){
			System.out.print(s+" ");
		}
		

	}


}
