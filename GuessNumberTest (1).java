package skhu;

import java.util.Random;



class GuessNumber{

	RandomNumber r = new RandomNumber();

	int a=0;
	
	public int getNumber(){		//������ �����ϴ� �żҵ�
		a=r.getRandom();
		
		return a;	
	}
	
	@Override			//�������̵� ǥ�� 
	public String toString(){				 
		return "��: "+this.a;		//���
	}


}


class Player{

	private int save;		// ���� �����ϹǷ� private 
	int c;
	RandomNumber r = new RandomNumber();
	int count=0;


	int a = r.getRandom();		//a�� �������� ���

	public void RandomNumber() {
		c=r.getRandom();
	}

	
	
	public boolean game(int a){		//���� �żҵ�
		
		
		for(int i=0;i<11;i++){		//0~10���� �� a���� ã�� 
			if(a==i)
				save=i;			//save�� ����
		}			
		
		if(save==c){		//������ �÷��̾ ���� ������ ���� ���
			System.out.println("�����Դϴ�.");
			count++;
			return true;		//true ����
		}
		else		// �׷�ġ �������
			System.out.println("Ʋ�Ƚ��ϴ�.");
			return false;		//false ����
	}

	
	public int count(){		//count ���
		return count;
	}
	
	
	
	@Override			//�������̵� ǥ�� 
	public String toString(){				 
		return "����: "+c ;		//���
	}

	
	

}

class RandomNumber{


	
	static public int getRandom(){		//�����Լ��� �����ϴ� �żҵ�
		
		Random random = new Random();		
		int a = random.nextInt(9)+1;		//0~10������ �����Լ� 
		
		random.setSeed(0);		// setseed�Լ�
		
		return a;

	}


}

public class GuessNumberTest{
	public static void main(String[] args){


		int goal;		

		GuessNumber gn1 = new GuessNumber();
		Player p1 = new Player();
		Player p2 = new Player();		
		

		while(true){		
			
			
			p1.RandomNumber();
			p2.RandomNumber();

			System.out.println("�÷��̾�1 " +p1.toString());
			System.out.println("�÷��̾�2 " +p2.toString());
			
			
			
			goal=gn1.getNumber();
			
			System.out.println(gn1.toString());
			if(p1.game(goal)){
				System.out.println("�÷��̾�1�� �̰���ϴ�.");
			}
			if(p2.game(goal)){
				System.out.println("�÷��̾�2�� �̰���ϴ�.");				
			};			
			
			if(p1.count()==1){
				System.out.println("������ �������ϴ�.");
					break;
			}
							
			
		}
				

	}


}
