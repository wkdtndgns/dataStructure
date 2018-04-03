package hw;

//***************************
//���ϸ�: QueueTest.java
//�ۼ���: �����
//�ۼ���: 2016.11.15
//����:  ����ť�� ��Ÿ���� �߻��ڷ����� CircularQueue Ŭ������ �����ϰ� �̿��ϴ� ���α׷��� �ۼ��Ͻÿ�
//***************************

import java.util.Scanner;

public class QueueTest {
	public static void main(String[] args){

		int result;
		int select;

		System.out.println("�����");
		System.out.println();

		CircularQueue cq =new CircularQueue();
		cq.createQueue(5);


		while(true){
			Scanner input=new Scanner(System.in);
			System.out.println("1:ť�� ����  2: ť���� ����  3:��ü���  4:����" );
			select= input.nextInt();

			if(select==1){
				System.out.println("������ ���� �Է��ϼ���:");
				result= input.nextInt();     // ������ input���� ���� ������ ����  
				cq.enQueue(result);
			}
			else if(select==2){
				cq.deQueue();

			}
			else if(select==3){
				System.out.print("ť :");
				System.out.println(cq);
			}
			else if(select==4){
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}

			else{
				System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���");
			}
		}


	}

}


class CircularQueue{

	private int count=0;
	private int front = 0;
	private int rear = 0;
	private int capacity=0;
	private int[] array;

	public void createQueue(int c){

		capacity=c;
		array = new int[capacity];

	}

	public boolean isEmpty(){
		if(count==0)	//count�� 0���� �ʱ�ȭ ���ֱ� ������ ī��Ʈ�� 0�̸� ť�� �������
			return true;
		else 
			return false;		

	}

	public boolean isFull(){
		if(count==capacity)		// count�� ũ��� �迭�� ũ�Ⱑ ������ �� ������
			return true;
		else
			return false;
	}


	public void enQueue(int item){
		if(this.isFull())
			System.out.println("ť�� ���� á���ϴ�. ���� �Ұ���");

		else{
			rear=(rear+1)%capacity;
			this.array[rear]=item;
			count++;
		}	
	}

	public void deQueue(){
		if(this.isEmpty())
			System.out.println("ť�� ������ϴ�. ���� �Ұ���");

		else {
			front=(front+1)%capacity;
			System.out.println("  "+array[front]+" ���� �����Ǿ����ϴ�.");
			count--;
		}
	}


	@Override
	public String toString(){

		String s= " ";
		
		if(this.isFull()){
			for(int i=0; i<count; i++)
				s+=array[(i+1)%capacity]+" ";
				
		}
		
		else{
			for(int i=(front+1)%capacity; i!=(rear+1)%capacity; i=(i+1)%capacity)
				s+=array[i]+" ";
		}
		return s;

	}

}