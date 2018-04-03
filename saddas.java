package lec;

public class saddas {
	public static void main(String[] args) {

		int[] a = new int[]{30,50,20,70,10,90,80,60};

		for(int s : a)
			System.out.print(s+" ");

			
		
		System.out.println();
		
		
		Sort sort =new Sort();
		
		sort.quick(a, 0, 7);
		
		
		for(int s : a)
			System.out.print(s+" ");
		
		
		}
		
	}
	

class Sort{
	
	public int partition(int a[], int begin, int end){
		
		int i= begin;
		int j= end+1;
		
		int pivot =a[begin];
		
		
		do{
			do{
				i=i+1;
			}while(i<=end && a[i]<pivot);
			
			do{
				j=j-1;
			}while(a[j]>pivot);
			
			if(i<j){
				int temp;
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				
			}
			
		}while(i<j);
	
		
		int temp;
		temp=a[begin];
		a[begin]=a[j];
		a[j]=temp;
		
		return j;
	}
	
	public void quick(int a[],int begin ,int end){
		if(begin <end){
			
			
			int p=partition(a,begin,end);	
			System.out.println(p);
			
			quick(a,begin,p-1);
			quick(a,p+1,end);
			
			
			
		}
		
		
	}
	
}

	