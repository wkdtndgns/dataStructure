package main;

//***************************
//���ϸ�: DoublyLinkedListTest.java
//�ۼ���: �����
//�ۼ���: 2016.10.12
//����:  ���� ���߿��� ����Ʈ �ε��� ���� �޾� ���� �ε��� ���� �޾� ���� �׸��� ���� �޾� ���� �׸��� ��ü ����ϰ� ������ ����ϴ�  ���α׷� 
//***************************



import java.util.Scanner;

public class DoublyLinkedListTest {
	public static void main(String[] args){

		int result;
		int select;
		int index;

		DoublyLinkedList dl = new DoublyLinkedList();


		System.out.println("hw6_3: �����");
		System.out.println("");




		while(true){
			Scanner input=new Scanner(System.in);
			System.out.println("1:�ε����� ����  2:�ε����� ���� 3:���� �޾Ƽ� ����  4:��ü���  5:���� ���  6:����" );
			select= input.nextInt();

			if(select==1){


				System.out.println("������ ���� �Է��ϼ���:");
				result= input.nextInt();     // ������ input���� ���� ������ ����  

				System.out.println("�ε��� ���� �Է��ϼ���:");
				index= input.nextInt();     // ������ input���� ���� ������ ����  


				if(index==0)	//index�� ó�� ���� �� null exception ������ ���Ƿ� 
					dl.insertFirst(result);		

				else if(0<index && index<=dl.getSize())	//index���� ó�� ���� �ƴҋ� 
					dl.insert(result, dl.checkIndexPre(index));	

				else 	//index���� �� �� �Է� ������
					System.out.println("�ε��� ���� �� �� �Է��ϼ̽��ϴ�.");

			}

			else if(select==2){

				System.out.println("������ �ε����� �Է��ϼ���:");
				index= input.nextInt();     // ������ input���� ���� ������ ����  

				if(0<=index && index<=dl.getSize())		
					dl.delete(dl.checkIndex(index));

				else
					System.out.println("�ε��� ���� �� �� �Է��ϼ̽��ϴ�.");

			}

			else if(select==3){

				System.out.println("������ ���� �Է��ϼ���:");
				result= input.nextInt();     // ������ input���� ���� ������ ����  

				if(dl.checkDelet(result)==true){
					dl.delete(dl.check(result));
				}		

				else
					System.out.println("���� ���Դϴ�.");
			}

			else if(select==4){

				System.out.println("����: "+ dl.getSize());	// ���� ���� �о��ش� 	
				System.out.println("����Ʈ:" + dl.toString() );	//����Ʈ���� �о��ش� 


			}	

			else if(select==5){

				System.out.println("����: "+ dl.getSize());	// ���� ���� �о��ش� 	
				System.out.println("����Ʈ:" + dl.toString() );	//����Ʈ���� �о��ش� 
				System.out.println("����: "+ dl.getSize());	// ���� ���� �о��ش� 	
				System.out.println("���� ����Ʈ:" + dl.inverseToString() );	//���� ����Ʈ���� �о��ش� 


			}	


			else if(select==6){
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}


			else{
				System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���");
			}

		}



	}

}


class DoublyLinkedList{


	Node head;	//�Ǿ��� ��带 ����ų �� �ִ� head node ����

	class Node {		//��� Ŭ���� ����

		int data;		//������ ��
		Node llink;		// ���� ��ũ�ּ� �� 
		Node rlink;		// ������ ��ũ�ּ� ��

	}

	public void insert(int x,Node pre){

		Node n = new Node();

		n.data=x;

		n.rlink=pre.rlink;

		pre.rlink=n;

		n.llink=pre;

		if(n.rlink!=null)		//������ ��尡 �ƴϸ� �߰��� ������ ��� 
			n.rlink.llink=n;

	}

	public void insertFirst(int x){

		Node n = new Node();	//���ο� ��� �� �����ϰ� 
		n.data = x;		//���� ���� 
		if(head==null){
			n.llink = null;	//x���� ������ �ִ� ��ũ �ʵ忡 head ���� ���� 
			n.rlink = null;
		}else{
			head.llink = n;
			n.rlink = head;
			n.llink = null;
		}

		head = n;		// head�� n ��ũ ���� ���� 

	}

	public void delete(Node old){	

		if(old.llink !=null)	//old�� ù���� ��尡 �ƴϸ�
			old.llink.rlink=old.rlink;
		else		//old�� ù��° ����ϋ� 
			head=old.rlink;

		if(old.rlink!=null)		//old�� ������ ��尡 �ƴϸ�
			old.rlink.llink=old.llink;

	}

	public Node check(int x){
		
		Node temp=head;
		Node old=null;
		
		while(temp.rlink!=null){	//null���ϋ����� ���� 
			if(temp.data==x){	//x�� ���� ������ ���� ã�´�
				if(head.data ==x){
					return head;
				}
				return old;
			}
			
			temp=temp.rlink;	
			old=temp;
		}

		return old;	//��� ���� �����Ѵ�. Ž�� ���н� null ����;

	}

	public Node checkIndexPre(int x){	//�ε����� �޾� �� ��� ���� ���� 
		Node temp=head;

		for(int i=0;i<x-1;i++){		//x����  �� �ּҸ�ũ�� ã������ ���ǹ�
			temp=temp.rlink; 		//temp�� �� �ּ� ���� ����	
		}

		return temp;

	}
	
	public Node checkIndex(int x){	//�ε����� �޾� �� ��� ���� ���� 
		Node temp=head;

		for(int i=0;i<x;i++){		//x����  �� �ּҸ�ũ�� ã������ ���ǹ�
			temp=temp.rlink; 		//temp�� �� �ּ� ���� ����	
		}

		return temp;

	}

	public boolean checkDelet(int x){

		boolean check=false;	//�ϴ� false������ �ʱ�ȭ ���ش� 	

		for(Node i=head ; i!=null ; i=i.rlink)	//��� i�� �����ּ� ���� i�� ���� �ƴҋ����� i�� ����ؼ� ���� �ּҷ� ���� )
			if(x==i.data)
				check=true;	//����Ʈ�ȿ� x���� ������ true 		

		return check;
	}

	public boolean checkFirst(int x){	

		boolean check=false;	//�ϴ� false������ �ʱ�ȭ ���ش� 	

		Node temp=head;

		if(temp.data==x)
			check=true;	//����Ʈ�ȿ� x���� ������ true 

		return check;
	}


	public int getSize()
	{
		int size=0;
		for(Node i=head ; i!=null ; i=i.rlink)	//��� i�� �����ּ� ���� i�� ���� �ƴҋ����� i�� ����ؼ� ���� �ּҷ� ���� 
			size++;	//size �� 
		return size;
	}


	public String inverseToString(){

		Node temp=head;

		String s =" ";

		while(temp.rlink != null)	//temp�� null�� ���ö����� ������	 
			temp=temp.rlink;	//temp�� ���ּҷ� ���� 

		for(Node i=temp ; i!=null ; i=i.llink)	//��� i�� ������ �ּ����� �������ּҸ� ó�� �ּұ���  ó���ּҿ��� llink�� null�� �����Ƿ�
			s+=i.data+" ";			


		return s;

	}

	@Override
	public String toString(){

		String s= " ";

		for(Node i=head ; i!=null ; i=i.rlink)	//��� i�� �����ּ� ���� i�� ���� �ƴҋ����� i�� ����ؼ� ���� �ּҷ� ���� 
			s+=i.data+" ";		

		return s;

	}




}
