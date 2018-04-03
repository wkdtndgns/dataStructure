package hw5_3;

import java.util.*;

public class ArrayListApi
{
	public static void main(String[] args)
	{
		System.out.println("hw5_3 전경준");
		ArrayList<String> str1 = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		
		String a;//버퍼 비우기
		int num1; //입력을 위한 변수

		while(true)
		{
			System.out.println("1:맨뒤삽입 2:인덱스로삽입 3:삭제 4:인덱스로조회 5:전체출력 6:종료");
			System.out.println("숫자를 입력하시오 :");
			
			num1 = input.nextInt();
			input.nextLine(); // 버퍼 비우기
			
			if(num1<=0 || num1>6)
			{ 
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				continue;
			}
			if(num1==1)
			{
				System.out.println("단어를 입력하세요 :");
				str1.add(input.nextLine());
			}
			else if(num1==2) 
			{
				System.out.println("0~"+str1.size()+"(포함) 사이의 숫자를 입력하세요.");
				num1 = input.nextInt();
				input.nextLine(); // 버퍼 비우기
				System.out.println("단어를 입력하세요 :");
				str1.add(num1,input.nextLine());
			}
			else if(num1==3) // 3 선택시 사용자로부터 단어를 입력받아 삭제
			{
				int b=-1;
				System.out.println("삭제할 단어를 입력하세요.");
				b=str1.indexOf(input.nextLine());
				if(b == -1)
				{
					System.out.println("삭제할 단어가 목록에 없습니다.");
					continue;
				}
				str1.remove(b);
			}
			else if(num1==4) //4:인덱스로조회
			{
				System.out.println("원하시는 인덱스를 조회해드립니다 :");
				System.out.println(str1.get(input.nextInt()));
			}
			else if(num1==5)
			{
				System.out.print("길이 : "+str1.size()+" || 내용 : [ ");
				for(String temp : str1)
					System.out.print(temp+" ");
				System.out.println("]");
			}
			else // 6 일 경우
				break;
		}
		System.out.println("종료합니다.");
	}
}
