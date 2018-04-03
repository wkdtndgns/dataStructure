package lec;

public class sadl {

	public static void main(String args[]){
		
		yourJob a =new yourJob();
		Thread t = new Mythread();
		a.doJob();
		t.start();
		for(int i=0; i<20; i++)
			System.out.print("M");
		
		
	}
	
}


class yourJob{
	public void doJob(){

		for(int i=0; i<20; i++)
			System.out.print("A");
		
	}
	
}

class Mythread extends Thread{
	
	public void run(){
		for(int i=0; i<20; i++)
			System.out.print("T");
		
	}
	
}