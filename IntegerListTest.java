package lab5_3;

import java.util.Scanner;

public class IntegerListTest {
	public static void main(String[] args) 
	{
		System.out.println("lab5_3: 전경준");
		System.out.println("여러명의 나이를 다루는 프로그램입니다.");

		// 나이를 저장하기 위해 비어있는 정수 리스트 생성
		IntegerList ageList = new IntegerList(); 

		// 나이를 입력받아 리스트에 저장
		Scanner in = new Scanner(System.in);
		int index;
		System.out.println("나이를 연속하여 입력하세요(음수값을 입력하면 종료합니다).");
		int age = in.nextInt();
		while(age >= 0) {
			ageList.add(age);
			age = in.nextInt();
		}
		
		// 나이 리스트 길이와 내용을 출력
		System.out.println("나이 리스트는 다음과 같습니다.");
		System.out.println("길이: " + ageList.getSize());
		System.out.print("내용: ");
		ageList.printList();

		
		//인덱스의 나이를 알려줌
		while(true)
		{
			System.out.println(0+"~"+(ageList.getSize()-1)+" 사이의 원하는 인덱스를 입력하면 나이를 알려드립니다 :");
			index = in.nextInt();
			if(index<0 || index>ageList.getSize())
			{
				System.out.println(0+"~"+(ageList.getSize()-1)+" 사이의  인덱스를 다시 입력해주세요.");
				continue;
			}
			else
				break;
		}
		System.out.println(index+"번 인덱스의 나이는 "+ageList.GetIndexAge(index)+"입니다.");
		
		//인덱스 삭제
		while(true)
		{
			System.out.println(0+"~"+(ageList.getSize()-1)+" 사이의 원하는 인덱스를 입력하면 삭제해드립니다 :");
			index = in.nextInt();
			if(index<0 || index>ageList.getSize())
			{
				System.out.println(0+"~"+(ageList.getSize()-1)+" 사이의  인덱스를 다시 입력해주세요.");
				continue;
			}
			else
				break;
		}
		ageList.RemoveIndex(index);
		
		System.out.println(ageList.toString());
		
	




	}
}
