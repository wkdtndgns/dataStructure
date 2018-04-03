//***************************
//파일명: LinkedListTest.java
//작성자: 장승훈
//작성일: 2016.10.10
//설명:  정수 연결 리스트 인덱스 값을 받아 삽입 인덱스 값을 받아 삭제 그리고 값을 받아 삭제 그리고 전체 출력하는 프로그램 
//***************************

package hw;

import java.util.Scanner;

class LinkedList{	

	Node head;	//맨앞의 노드를 가리킬 수 있는 head node 생성

	class Node {		//노드 클래스 생성

		int data;		//데이터 값
		Node link;		// 주소 값 

	}

	public void insertLast(int x)	//정수값을 받아 마지막에 리스트에 넣는 배열 생성
	{
		Node n = new Node();	//새로운 노드 값 생성하고 
		n.data = x;		//값을 넣음 


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

	public void insertFirst(int x){

		Node n = new Node();	//새로운 노드 값 생성하고 
		n.data = x;		//값을 넣음 
		n.link = head;	//x값을 가지고 있는 링크 필드에 head 값을 저장 

		head = n;		// head에 n 링크 값을 저장 


	}



	public void insertMiddle(int x, Node pre){

		Node n = new Node();	//새로운 노드 값 생성하고 
		n.data=x;

		if(head==null){		//공백리스트일 경우

			head=n;		
			n.link=null;
		}


		else{			//공백리스트가 아닐경우
			n.link=pre.link;
			pre.link=n;
		}

	}

	public void delete(Node pre){

		Node old = new Node();	//삭제 대상이 되는 노드 값 생성

		if(head==null)		//공백 리스트인 경우
			System.out.println("삭제 할 데이터가 없습니다.");

		else		//공백 리스트가 아닐 경우
		{
			old=pre.link;	// 삭제 대상의 주소를 old에 줌 

			if(old==null)		//old가  null이라면 끝 
				return;

			pre.link=old.link;	//pre링크 주소를 삭제 대상 주소의 링크로 바꿈 
		}


	}	

	public void deleteFirst(){	//리스트 맨 앞의 값을 삭제

		Node temp=head;

		head=temp.link;

	}

	public Node check(int x){
		Node temp=head;
		Node pre = null;

		while(temp.link!=null){	//null값일떄가지 돈다 
			if(temp.data==x)	//x와 같은 데이터 값을 찾는다 
				return pre;					

			pre=temp;
			temp=temp.link;		//temp에 앞 주소 값을 저장
		}

		return pre;	//노드 값을 리턴한다. 탐색 실패시 null 리턴;

	}

	public Node checkIndex(int x){	//인덱스를 받아 전 노드 값을 리턴 
		Node temp=head;

		for(int i=0;i<x-1;i++){		//x값의 전 링크를 찾기위한 조건문
			temp=temp.link; 		//temp에 앞 주소 값을 저장	
		}

		return temp;

	}


	public boolean checkDelet(int x){

		boolean check=false;	//일단 false값으로 초기화 해준다 	

		for(Node i=head ; i!=null ; i=i.link)	//노드 i에 시작주소 지정 i가 널이 아닐떄까지 i는 계속해서 다음 주소로 변경 )
			if(x==i.data)
				check=true;	//리스트안에 x값이 있으면 true 		

		return check;
	}

	public boolean checkFirst(int x){

		boolean check=false;	//일단 false값으로 초기화 해준다 	

		Node temp=head;

		if(temp.data==x)
			check=true;	//리스트안에 x값이 있으면 true 

		return check;
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
		int index;

		LinkedList l = new LinkedList();


		System.out.println("hw6_2: 장승훈");
		System.out.println("");


		while(true){
			Scanner input=new Scanner(System.in);
			System.out.println("1:인덱스로 삽입  2:인덱스로 삭제 3:값을 받아서 삭제  4:전체출력  5:종료");
			select= input.nextInt();

			if(select==1){


				System.out.println("삽입할 값을 입력하세요:");
				result= input.nextInt();     // 변수에 input에서 받은 데이터 저장  

				System.out.println("인덱스 값을 입력하세요:");
				index= input.nextInt();     // 변수에 input에서 받은 데이터 저장  



				if(index==0)		// index가 0을 가리킬떄  
					l.insertFirst(result);			//처음에 삽입			

				else if(index==l.getSize())		//index값이 맨 마지막을 가리킬떄
					l.insertLast(result);		//마지막에 삽입			

				else if(0<index && index<l.getSize())	//index값이 중간을 가리킬떄
					l.insertMiddle(result, l.checkIndex(index));	//중간에 삽입

				else 	//index값이 잘 못 입력 됬을떄
					System.out.println("인덱스 값을 잘 못 입력하셨습니다.");

			}

			else if(select==2){

				System.out.println("삭제할 인덱스를 입력하세요:");
				index= input.nextInt();     // 변수에 input에서 받은 데이터 저장  

				if(0<=index && index<=l.getSize())		
					if(index==0)				//교재 대로 했는데 삭제 알고리즘이 잘못된거 같아서 처음 삭제인 경우를 만듬 
						l.deleteFirst();
					else
						l.delete(l.checkIndex(index));		//처음 삭제가 아닌 경우

				else
					System.out.println("인덱스 값을 잘 못 입력하셨습니다.");

			}

			else if(select==3){

				System.out.println("삭제할 값을 입력하세요:");
				result= input.nextInt();     // 변수에 input에서 받은 데이터 저장  

				if(l.checkDelet(result)==true){
					
					if(l.checkFirst(result)==true)		//처음 수를 가르킬 떄 nullexception 오류가 남  그래서 처음 삭제인 경우를 따로 만듬
						l.deleteFirst();
					
					else
						l.delete(l.check(result));		//처음 삭제가 아닐 경우
					
				}
				else
					System.out.println("없는 값입니다.");
			}

			else if(select==4){

				System.out.println("길이: "+ l.getSize());	// 길이 값을 읽어준다 	
				System.out.println("리스트:" + l.toString() );	//리스트값을 읽어준다 


			}	

			else if(select==5){
				System.out.println("프로그램을 종료합니다.");
				break;
			}


			else{
				System.out.println("잘 못 입력하셨습니다. 다시 입력해 주세요");
			}

		}

	}

} 