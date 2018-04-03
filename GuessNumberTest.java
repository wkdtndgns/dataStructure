package wk;

import java.util.Random;



class GuessNumber{

	Random random = new Random();
	int a = random.nextInt(9)+1;

	@Override			//오버라이드 표시 
	public String toString(){				 
		return "랜덤: "+a ;		//출력
	}
}


class Player{

	private int save;


	public void check(int r){		
		for(int i=0;i<11;i++){
			if(r==i)
				save=i;
		}

	}
	
	@Override			//오버라이드 표시 
	public String toString(){				 
		return "추측: "+save ;		//출력
	}
}

class RandomNumber{
	
		Random random = new Random();
		int a = random.nextInt(9)+1;
						
}

public class GuessNumberTest{
	public static void main(String[] args){


		GuessNumber gn1 = new GuessNumber();
		Player p1 = new Player();
		Player p2 = new Player();
		
		p1.RandomNumber();
		
		
		System.out.println(gn1.toString());
		
		



	}


}
