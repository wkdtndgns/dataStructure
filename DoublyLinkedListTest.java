package main;

//***************************
//파일명: DoublyLinkedListTest.java
//작성자: 장승훈
//작성일: 2016.10.12
//설명:  정수 이중연결 리스트 인덱스 값을 받아 삽입 인덱스 값을 받아 삭제 그리고 값을 받아 삭제 그리고 전체 출력하고 역순을 출력하는  프로그램 
//***************************



import java.util.Scanner;

public class DoublyLinkedListTest {
	public static void main(String[] args){

		int result;
		int select;
		int index;

		DoublyLinkedList dl = new DoublyLinkedList();


		System.out.println("hw6_3: 장승훈");
		System.out.println("");




		while(true){
			Scanner input=new Scanner(System.in);
			System.out.println("1:인덱스로 삽입  2:인덱스로 삭제 3:값을 받아서 삭제  4:전체출력  5:역순 출력  6:종료" );
			select= input.nextInt();

			if(select==1){


				System.out.println("삽입할 값을 입력하세요:");
				result= input.nextInt();     // 변수에 input에서 받은 데이터 저장  

				System.out.println("인덱스 값을 입력하세요:");
				index= input.nextInt();     // 변수에 input에서 받은 데이터 저장  


				if(index==0)	//index가 처음 값일 떄 null exception 오류가 나므로 
					dl.insertFirst(result);		

				else if(0<index && index<=dl.getSize())	//index값이 처음 값이 아닐떄 
					dl.insert(result, dl.checkIndexPre(index));	

				else 	//index값이 잘 못 입력 됬을떄
					System.out.println("인덱스 값을 잘 못 입력하셨습니다.");

			}

			else if(select==2){

				System.out.println("삭제할 인덱스를 입력하세요:");
				index= input.nextInt();     // 변수에 input에서 받은 데이터 저장  

				if(0<=index && index<=dl.getSize())		
					dl.delete(dl.checkIndex(index));

				else
					System.out.println("인덱스 값을 잘 못 입력하셨습니다.");

			}

			else if(select==3){

				System.out.println("삭제할 값을 입력하세요:");
				result= input.nextInt();     // 변수에 input에서 받은 데이터 저장  

				if(dl.checkDelet(result)==true){
					dl.delete(dl.check(result));
				}		

				else
					System.out.println("없는 값입니다.");
			}

			else if(select==4){

				System.out.println("길이: "+ dl.getSize());	// 길이 값을 읽어준다 	
				System.out.println("리스트:" + dl.toString() );	//리스트값을 읽어준다 


			}	

			else if(select==5){

				System.out.println("길이: "+ dl.getSize());	// 길이 값을 읽어준다 	
				System.out.println("리스트:" + dl.toString() );	//리스트값을 읽어준다 
				System.out.println("길이: "+ dl.getSize());	// 길이 값을 읽어준다 	
				System.out.println("역순 리스트:" + dl.inverseToString() );	//역순 리스트값을 읽어준다 


			}	


			else if(select==6){
				System.out.println("프로그램을 종료합니다.");
				break;
			}


			else{
				System.out.println("잘 못 입력하셨습니다. 다시 입력해 주세요");
			}

		}



	}

}


class DoublyLinkedList{


	Node head;	//맨앞의 노드를 가리킬 수 있는 head node 생성

	class Node {		//노드 클래스 생성

		int data;		//데이터 값
		Node llink;		// 왼쪽 링크주소 값 
		Node rlink;		// 오른쪽 링크주소 값

	}

	public void insert(int x,Node pre){

		Node n = new Node();

		n.data=x;

		n.rlink=pre.rlink;

		pre.rlink=n;

		n.llink=pre;

		if(n.rlink!=null)		//마지막 노드가 아니면 중간에 삽입인 경우 
			n.rlink.llink=n;

	}

	public void insertFirst(int x){

		Node n = new Node();	//새로운 노드 값 생성하고 
		n.data = x;		//값을 넣음 
		if(head==null){
			n.llink = null;	//x값을 가지고 있는 링크 필드에 head 값을 저장 
			n.rlink = null;
		}else{
			head.llink = n;
			n.rlink = head;
			n.llink = null;
		}

		head = n;		// head에 n 링크 값을 저장 

	}

	public void delete(Node old){	

		if(old.llink !=null)	//old가 첫번쨰 노드가 아니면
			old.llink.rlink=old.rlink;
		else		//old가 첫번째 노드일떄 
			head=old.rlink;

		if(old.rlink!=null)		//old가 마지막 노드가 아니면
			old.rlink.llink=old.llink;

	}

	public Node check(int x){
		
		Node temp=head;
		Node old=null;
		
		while(temp.rlink!=null){	//null값일떄가지 돈다 
			if(temp.data==x){	//x와 같은 데이터 값을 찾는다
				if(head.data ==x){
					return head;
				}
				return old;
			}
			
			temp=temp.rlink;	
			old=temp;
		}

		return old;	//노드 값을 리턴한다. 탐색 실패시 null 리턴;

	}

	public Node checkIndexPre(int x){	//인덱스를 받아 전 노드 값을 리턴 
		Node temp=head;

		for(int i=0;i<x-1;i++){		//x값의  전 주소링크를 찾기위한 조건문
			temp=temp.rlink; 		//temp에 앞 주소 값을 저장	
		}

		return temp;

	}
	
	public Node checkIndex(int x){	//인덱스를 받아 전 노드 값을 리턴 
		Node temp=head;

		for(int i=0;i<x;i++){		//x값의  전 주소링크를 찾기위한 조건문
			temp=temp.rlink; 		//temp에 앞 주소 값을 저장	
		}

		return temp;

	}

	public boolean checkDelet(int x){

		boolean check=false;	//일단 false값으로 초기화 해준다 	

		for(Node i=head ; i!=null ; i=i.rlink)	//노드 i에 시작주소 지정 i가 널이 아닐떄까지 i는 계속해서 다음 주소로 변경 )
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
		for(Node i=head ; i!=null ; i=i.rlink)	//노드 i에 시작주소 지정 i가 널이 아닐떄까지 i는 계속해서 다음 주소로 변경 
			size++;	//size 업 
		return size;
	}


	public String inverseToString(){

		Node temp=head;

		String s =" ";

		while(temp.rlink != null)	//temp를 null이 나올때까지 돌린다	 
			temp=temp.rlink;	//temp의 앞주소로 변경 

		for(Node i=temp ; i!=null ; i=i.llink)	//노드 i에 마지막 주소지정 마지막주소를 처음 주소까지  처음주소에도 llink에 null이 있으므로
			s+=i.data+" ";			


		return s;

	}

	@Override
	public String toString(){

		String s= " ";

		for(Node i=head ; i!=null ; i=i.rlink)	//노드 i에 시작주소 지정 i가 널이 아닐떄까지 i는 계속해서 다음 주소로 변경 
			s+=i.data+" ";		

		return s;

	}




}
