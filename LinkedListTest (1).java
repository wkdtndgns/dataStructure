//***************************
//파일명: LinkedListTest.java
//작성자: 장승훈
//작성일: 2016.10.06
//설명:  정수 연결 리스트 마지막에 삽입하고 전체 출력하는 프로그램 
//***************************

package hw;

import java.util.Scanner;

class LinkedList{	

	Node head;	//맨앞의 노드를 가리킬 수 있는 head node 생성

	class Node {		//노드 클래스 생성

		int data;		//데이터 값
		Node link;		// 주소 값 

	}

	public void insertLast(int item)	//정수값을 받아 마지막에 리스트에 넣는 배열 생성
	{
		Node n = new Node();
		n.data = item;	// 받은 정수값을 노드데이터에 저장한다 	

		
		if(head==null)	//만약에 아무것도 넣지 않은 상태라면
			head=n;	 //head  값에다가  n주소값 입력 

		else		//안에 들어있으면
		{ 
			Node temp=head;		// 다음 주소 값을 알려주는 temp 선언  그리고 시작주소값을 저장 

			while(temp.link!=null)	//null값일떄가지 돈다 
				temp=temp.link;	//temp에 앞 주소 값을 저장
			temp.link=n;	//마지막 temp에 새로받은 주소값 저장
		}
	}
	

		
	public int getSize()
	{
		int size=0;
		for(Node i=head ; i!=null ; i=i.link)	//노드 i에 시작주소 지정 i가 널이 아닐떄까지 i는 계속해서 다음 주소로 변경 
			size++;	//size 업 
		return size;
	}


	@Override
	public String toString(){

		String s= " ";

		for(Node i=head ; i!=null ; i=i.link)	//노드 i에 시작주소 지정 i가 널이 아닐떄까지 i는 계속해서 다음 주소로 변경 
			s+=i.data+" ";		

		return s;

	}

}

public class LinkedListTest{


	public static void main(String[] args){
		int result;
		int select;

		LinkedList l = new LinkedList();



		while(true){
			Scanner input=new Scanner(System.in);
			System.out.println("1: 마지막에 삽입   2:전체출력  3:종료");
			select= input.nextInt();

			if(select==1){

				System.out.println("삽입할 값을 입력하세요:");
				result= input.nextInt();     // 변수에 input에서 받은 데이터 저장  
				l.insertLast(result);		//정수값을 last클래스 안에다 넣는다		


			}

			else if(select==2){

				System.out.println("길이: "+ l.getSize());	// 길이 값을 읽어준다 	
				System.out.println("리스트:" + l.toString() );	//리스트값을 읽어준다 


			}	

			else if(select==3){
				System.out.println("프로그램을 종료합니다.");
				break;
			}


		}

	}

} 