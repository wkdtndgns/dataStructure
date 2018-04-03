package lec;

public class sort {
	public static void main(String[] args) {

		int[] a = new int[]{30,50,20,70,10,90,80,60};

		for(int s : a)
			System.out.print(s+" ");
			
			
		
		System.out.println();
		
		int i,j,item;
		
		for(i=1;i<a.length;i++){
			item=a[i];
			
			
			for(j=i; j>0 && a[j-1]>item; j--){
				a[j]=a[j-1];
			}
			
			a[j]=item;
		}
		
		
		for(int s : a)
			System.out.print(s+" ");
		
		
			
	}
	
	
}
