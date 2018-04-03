package hw;

import java.util.Random;



class GuessNumber{

	RandomNumber r = new RandomNumber();

	int a=0;
	
	public int getNumber(){		//정답을 생성하는 매소드
		a=r.getRandom();
		
		return a;	
	}
	
	@Override			//오버라이드 표시 
	public String toString(){				 
		return "답: "+this.a;		//출력
	}


}


class Player{

	private int save;		// 값을 저장하므로 private 
	int c;
	RandomNumber r = new RandomNumber();
	int count=0;


	int a = r.getRandom();		//a에 랜덤변수 출력

	public void RandomNumber() {
		c=r.getRandom();
	}

	
	
	public boolean game(int a){		//게임 매소드
		
		
		for(int i=0;i<11;i++){		//0~10까지 중 a값을 찾음 
			if(a==i)
				save=i;			//save에 저장
		}			
		
		if(save==c){		//정답이 플레이어가 만든 변수랑 같을 경우
			System.out.println("정답입니다.");
			count++;
			return true;		//true 리턴
		}
		else		// 그렇치 않을경우
			System.out.println("틀렸습니다.");
			return false;		//false 리턴
	}

	
	public int count(){		//count 출력
		return count;
	}
	
	
	
	@Override			//오버라이드 표시 
	public String toString(){				 
		return "추측: "+c ;		//출력
	}

	
	

}

class RandomNumber{


	
	static public int getRandom(){		//랜덤함수를 생성하는 매소드
		
		Random random = new Random();		
		int a = random.nextInt(9)+1;		//0~10까지의 랜덤함수 
		
		random.setSeed(0);		// setseed함수
		
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

			System.out.println("플레이어1 " +p1.toString());
			System.out.println("플레이어2 " +p2.toString());
			
			
			
			goal=gn1.getNumber();
			
			System.out.println(gn1.toString());
			if(p1.game(goal)){
				System.out.println("플레이어1이 이겼습니다.");
			}
			if(p2.game(goal)){
				System.out.println("플레이어2가 이겼습니다.");				
			};			
			
			if(p1.count()==1){
				System.out.println("게임이 끝났습니다.");
					break;
			}
							
			
		}
				

	}


}