//***************************
// 파일명: StringList.java
// 작성자: 장승훈
// 작성일: 2016.09.27
// 설명: - StringList에 다음 기능을 갖는다.
//	삽입: 인덱스와 문자열을 매개변수로 받아 해당 위치에 삽입한다.
//	삭제: 문자열을 매개변수로 받아 해당 원소를 삭제한다.(중복시 앞에 것만 삭제)
//	조회: 인덱스를 매개변수로 받아 해당 위치의 원소를 리턴한다.
//	길이조회: 리스트의 길이를 리턴
//	내용조회: 리스트 내용을 문자열로 만들어 리턴(toString 오버라이드)
//***************************

package hw;

import java.util.Scanner;

class StringList{		//class 선언

	String [] array;	//비어있는 문자열 리스트 선언	
	int count;			//문자열 크기 재는 변수 선언
	int size;			//배열의 크기 재는 변수 선언
	int pull=-1;			//단어를 옮기기위한 변수 선언 -1로 초기화
	String before;


	public StringList(){
		size = 10;   
		count = 0;
		array = new String[size];		//배열의 크기를 늘려줌 
	}

	public void increaseSize(){

		size=size*2;		
		array = new String[size];	// 배열에 더  넣을 수 있게 2배로 늘려줌 	

	}

	public void insertion(int index, String word) {			//삽입	
		if(index<0 || index>count) // 배열의 범위 값이 아닐 떄 
		{ 
			System.out.println("삽입할 수 없습니다. ");
			return;		//종료
		}		

		if(count==size){		// 배열의 길이와 크기가 같다면 
			increaseSize();		//배열의 크기를늘려줌

		}

		if(index == count)  {	//사이에 안넣어도 될 떄 
			array[index] = word;	
			count++;			//길이 증가
		}

		else{					//사이에 삽입 해야할 때
			for(int i=count++ ; index<=i ; i--)	
				array[i+1] = array[i];		//배열 i+1에 i번쨰 배열을 저장 
			array[index] = word;			// 배열을 앞으로 떙겨놓고 자리에다 word 저장
		}



	}

	public void delete(String word){		//삭제


		for(int i=0 ; i<count ; i++)
		{
			if(word.equals(array[i])){		//identity 비교하면 실행이 안된다 equals 비교를 해야하기 떄문에  equals메소드 사용
				pull=i;		//pull값에 밀기위해 값을 저장
				count--;	//길이를 줄여준다 
			}			
		}		


		if(pull<0 ) //단어가 배열에 없을떄  pull값에 저장이 되지 않았을떄 
		{
			System.out.println("삭제할 수 없습니다.");
			return ;
		}
		else //단어가 배열에 있을때
		{
			for(; pull<count; pull++){

				before=array[pull+1];		// 삭제된 값의 앞의 값을 before에다 넣는다  
				array[pull]=before;		// before의 받은 값을 삭제된 값에다 넣는다   

			}



		}


	}

	public String check(int index){		// 조회

		if(index<0 || index>count) 	//범위 입력 틀릴때
			return "조회가 불가능 합니다. " ;

		return	array[index];		
	}

	public int getCount(){		//길이을 조회 한다 
		return count;

	}

	@Override			//오버라이드 표시 
	public String toString(){

		String s = "";		// return 출력하기 위한 s선언 초기화
		for(int i=0; i<count ; i++ )
			s = s + array[i]+" ";	// s에 배열의 값 모두 저장 
		return "내용 : "+s ;		//출력
	}

}


public class StringListTest {

	public static void main(String args[]){

		int result;			
		StringList s1 = new StringList();	


		System.out.println("hw5_3 장승훈");
		System.out.println("");

		while(true){		// 

			System.out.println("1:인덱스로 삽입  2:삭제  3:인덱스로 조회   4:전체출력  5:종료 ");

			Scanner input=new Scanner(System.in);		// 데이터를 받아 input에 저장 
			System.out.println("선택하세요 ");
			result= input.nextInt();		//result에  input에서 받은 데이터 저장 
			input.nextLine(); // 버퍼 비우기

			if(result<1 || result>5){		//잘못 입력했을떄 
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				continue;		//종료되지 않기 위해 계속해서 한다. 
			}

			else if(result==1){		//인덱스와 단어를 입력받아 삽입

				System.out.println("0~"+s1.getCount()+"사이의 숫자를 입력하세요.");	
				result = input.nextInt();
				input.nextLine(); // 버퍼 비우기				

				System.out.println("삽입할 단어를 입력하세요:");	
				s1.insertion(result, input.nextLine());

			}

			else if(result==2){			//단어를 입력받아 단어 삭제
				System.out.println("삭제할 단어를 입력하세요.");
				s1.delete(input.nextLine());


			}	

			else if(result==3){		//인덱스를 조회

				System.out.println("인덱스를 조회 :");
				System.out.println("숫자만 입력하세요.");
				System.out.println(s1.check(input.nextInt()));

			}

			else if(result==4){			// 길이와 내용을 출력
				System.out.println("길이: " +s1.getCount());
				System.out.println(s1.toString());
			}

			else if(result==5){		//5일경우 종료 
				break;
			}	

		}




	}


}
