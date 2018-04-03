package hw;

//***************************
//파일명: QueueTest.java
//작성자: 장승훈
//작성일: 2016.11.15
//설명:  원형큐를 나타내는 추상자료형인 CircularQueue 클래스를 정의하고 이용하는 프로그램을 작성하시오
//***************************

import java.util.Scanner;

public class QueueTest {
	public static void main(String[] args){

		int result;
		int select;

		System.out.println("장승훈");
		System.out.println();

		CircularQueue cq =new CircularQueue();
		cq.createQueue(5);


		while(true){
			Scanner input=new Scanner(System.in);
			System.out.println("1:큐에 삽입  2: 큐에서 삭제  3:전체출력  4:종료" );
			select= input.nextInt();

			if(select==1){
				System.out.println("삽입할 값을 입력하세요:");
				result= input.nextInt();     // 변수에 input에서 받은 데이터 저장  
				cq.enQueue(result);
			}
			else if(select==2){
				cq.deQueue();

			}
			else if(select==3){
				System.out.print("큐 :");
				System.out.println(cq);
			}
			else if(select==4){
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			else{
				System.out.println("잘 못 입력하셨습니다. 다시 입력해 주세요");
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
		if(count==0)	//count가 0으로 초기화 되있기 떄문에 카운트가 0이면 큐가 비어있음
			return true;
		else 
			return false;		

	}

	public boolean isFull(){
		if(count==capacity)		// count의 크기와 배열의 크기가 같으면 다 차있음
			return true;
		else
			return false;
	}


	public void enQueue(int item){
		if(this.isFull())
			System.out.println("큐가 가득 찼습니다. 삽입 불가능");

		else{
			rear=(rear+1)%capacity;
			this.array[rear]=item;
			count++;
		}	
	}

	public void deQueue(){
		if(this.isEmpty())
			System.out.println("큐가 비었습니다. 삭제 불가능");

		else {
			front=(front+1)%capacity;
			System.out.println("  "+array[front]+" 값이 삭제되었습니다.");
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