package wk;

import java.util.Random;



class GuessNumber{

	Random random = new Random();
	int a = random.nextInt(9)+1;

	@Override			//�������̵� ǥ�� 
	public String toString(){				 
		return "����: "+a ;		//���
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
	
	@Override			//�������̵� ǥ�� 
	public String toString(){				 
		return "����: "+save ;		//���
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
